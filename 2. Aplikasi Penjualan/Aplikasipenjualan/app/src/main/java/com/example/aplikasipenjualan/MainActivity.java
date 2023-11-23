package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText namaPelanggan, namaBarang, jumlah, harga, jumlahBayar;
    private Button btnProses, btnHapus, btnKeluar;
    private TextView textPelanggan, textBarang, textJumlah, textHarga, textJumlahBayar, textTotal, textKembalian, textBonus, textKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaPelanggan = (EditText) findViewById(R.id.etNamaPelanggan);
        namaBarang = (EditText) findViewById(R.id.etNamaBarang);
        jumlah = (EditText) findViewById(R.id.etJmlBarang);
        harga = (EditText) findViewById(R.id.etHarga);
        jumlahBayar = (EditText) findViewById(R.id.etJmlUang);
        btnProses = (Button) findViewById(R.id.btnProses);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        textPelanggan = (TextView) findViewById(R.id.tvNamaPembeli);
        textBarang = (TextView) findViewById(R.id.tvNamaBarang);
        textJumlah = (TextView) findViewById(R.id.tvJmlBarang);
        textHarga = (TextView) findViewById(R.id.tvHarga);
        textJumlahBayar = (TextView) findViewById(R.id.tvUangBayar);
        textTotal = (TextView) findViewById(R.id.tvTotal);
        textKembalian = (TextView) findViewById(R.id.tvKembalian);
        textBonus = (TextView) findViewById(R.id.tvBonus);
        textKeterangan = (TextView) findViewById(R.id.tvKeterangan);


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strjumlah = jumlah.getText().toString().trim();
                    String strharga = harga.getText().toString().trim();
                    String strbayar = jumlahBayar.getText().toString().trim();
                    String keterangan = "";

                    int jumlah = Integer.parseInt(strjumlah);
                    int harga = Integer.parseInt(strharga);
                    int bayar = Integer.parseInt(strbayar);

                    int total = jumlah * harga;
                    int kembalian = bayar - total;

                    if (kembalian > 0) {
                        keterangan = "Menunggu Kembalian";
                    } else if (kembalian == 0) {
                        keterangan = "Pembayaran Selesai";
                    } else if (kembalian < 0) {
                        keterangan = "Uang kurang, silahkan bayar";
                    }

                    textPelanggan.setText("Nama Pembeli : " + namaPelanggan.getText().toString());
                    textBarang.setText("Nama Barang : " + namaBarang.getText().toString());
                    textJumlah.setText("Jumlah Barang : " + strjumlah);
                    textHarga.setText("Harga Barang : " + strharga);
                    textJumlahBayar.setText("Uang Pembayatan : " + jumlahBayar.getText().toString());
                    textTotal.setText("Total : " + total);
                    textKembalian.setText("Uang Kembalian : " + kembalian);
                    textBonus.setText("Bonus : Voucher Belanja Rp. 50.000");
                    textKeterangan.setText("Keterangan : " + keterangan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaPelanggan.setText("");
                namaBarang.setText("");
                jumlah.setText("");
                harga.setText("");
                jumlahBayar.setText("");
                textPelanggan.setText("");
                textBarang.setText("");
                textJumlah.setText("");
                textHarga.setText("");
                textJumlahBayar.setText("");
                textTotal.setText("");
                textKembalian.setText("");
                textBonus.setText("");
                textKeterangan.setText("");
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}