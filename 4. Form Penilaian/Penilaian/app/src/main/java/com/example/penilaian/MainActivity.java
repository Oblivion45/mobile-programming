package com.example.penilaian;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText namaMahasiswa, nilaiquiz1, nilaiquiz2, nilaiets, nilaieas;
    private Button btnProses, btnHapus, btnKeluar;
    private TextView textMahasiswa, textquiz1, textquiz2, textets, texteas, textjumlahnilai, textrataratanilai, textabjadnilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaMahasiswa = (EditText) findViewById(R.id.etNamaMahasiswa);
        nilaiquiz1 = (EditText) findViewById(R.id.etquiz1);
        nilaiquiz2 = (EditText) findViewById(R.id.etquiz2);
        nilaiets = (EditText) findViewById(R.id.etets);
        nilaieas = (EditText) findViewById(R.id.eteas);
        btnProses = (Button) findViewById(R.id.btnProses);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        textMahasiswa = (TextView) findViewById(R.id.tvNamaMahasiswa);
        textquiz1 = (TextView) findViewById(R.id.tvNilaiquiz1);
        textquiz2 = (TextView) findViewById(R.id.tvNilaiquiz2);
        textets = (TextView) findViewById(R.id.tvNilaiets);
        texteas = (TextView) findViewById(R.id.tvNilaieas);
        textjumlahnilai = (TextView) findViewById(R.id.jumlahnilai);
        textrataratanilai = (TextView) findViewById(R.id.rataratanilai);
        textabjadnilai = (TextView) findViewById(R.id.abjadnilai);


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strquiz1 = nilaiquiz1.getText().toString().trim();
                    String strquiz2 = nilaiquiz2.getText().toString().trim();
                    String strets = nilaiets.getText().toString().trim();
                    String streas = nilaieas.getText().toString().trim();
                    String abjad = "";

                    int quiz1 = Integer.parseInt(strquiz1);
                    int quiz2 = Integer.parseInt(strquiz2);
                    int ets = Integer.parseInt(strets);
                    int eas = Integer.parseInt(streas);

                    int jumlah = quiz1+quiz2+ets+eas;
                    int ratarata = jumlah / 4;

                    if (ratarata >= 81) {
                        abjad = "A";
                    } else if (ratarata >= 61 && ratarata < 81) {
                        abjad = "B";
                    } else if (ratarata >= 41 && ratarata < 61) {
                        abjad = "C";
                    } else if (ratarata >= 21 && ratarata < 41) {
                        abjad = "D";
                    } else {
                        abjad = "E";
                    }

                    textMahasiswa.setText("Nama Mahasiswa : " + namaMahasiswa.getText().toString());
                    textquiz1.setText("Nilai Quiz 1 : " + nilaiquiz1.getText().toString());
                    textquiz2.setText("Nilai Quiz 2 : " + nilaiquiz2.getText().toString());
                    textets.setText("Nilai ETS : " + nilaiets.getText().toString());
                    texteas.setText("Nilai EAS : " + nilaieas.getText().toString());
                    textjumlahnilai.setText("Jumlah Nilai : " + jumlah);
                    textrataratanilai.setText("Rata - Rata Nilai : " + ratarata);
                    textabjadnilai.setText("Nilai Huruf : " + abjad);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaMahasiswa.setText("");
                nilaiquiz1.setText("");
                nilaiquiz2.setText("");
                nilaiets.setText("");
                nilaieas.setText("");
                textMahasiswa.setText("");
                textquiz1.setText("");
                textquiz2.setText("");
                textets.setText("");
                texteas.setText("");
                textjumlahnilai.setText("");
                textrataratanilai.setText("");
                textabjadnilai.setText("");

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