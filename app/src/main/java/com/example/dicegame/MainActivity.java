package com.example.dicegame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button_rzut;
    private Button button_reset;
    private TextView rzut_1;
    private TextView rzut_2;
    private TextView rzut_3;
    private TextView rzut_4;
    private TextView rzut_5;
    private TextView tytul;
    private TextView wynik_losowania;
    private TextView wynik_gry;
    private TextView liczba_rzutow;
    private Random l = new Random();
    int wynik_Gry = 0;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzut_1 = findViewById(R.id.rzut1);
        rzut_2 = findViewById(R.id.rzut2);
        rzut_3 = findViewById(R.id.rzut3);
        rzut_4 = findViewById(R.id.rzut4);
        rzut_5 = findViewById(R.id.rzut5);
        tytul = findViewById(R.id.tytul);
        wynik_gry = findViewById(R.id.wynik_gry);
        wynik_losowania = findViewById(R.id.wynik_losowania);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);
        button_rzut = findViewById(R.id.button_rzut);
        button_reset = findViewById(R.id.button_reset);

        button_rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rad1 = l.nextInt(6) + 1;
                rzut_1.setText(Integer.toString(rad1));
                int rad2 = l.nextInt(6) + 1;
                rzut_2.setText(Integer.toString(rad2));
                int rad3 = l.nextInt(6) + 1;
                rzut_3.setText(Integer.toString(rad3));
                int rad4 = l.nextInt(6) + 1;
                rzut_4.setText(Integer.toString(rad4));
                int rad5 = l.nextInt(6) + 1;
                rzut_5.setText(Integer.toString(rad5));


                int[] liczby = {rad1, rad2, rad3, rad4, rad5};
                int wynik = 0;
                int[] count = new int[6]; // liczby od 1-6

                //liczymy zdarzenia
                for (int i = 0; i < liczby.length; i++) {
                    count[liczby[i] - 1]++;
                }

                // liczymy wynik na podstawie zdarzeń
                for (int i = 0; i < count.length; i++) {
                    if (count[i] > 1) {
                        wynik += (i + 1) * count[i];
                    }
                }

                wynik_losowania.setText("Wynik tego losowania: " + wynik);
                licznik++;
                liczba_rzutow.setText("Liczba rzutów: " + licznik);
                updateScore(wynik);

            }
        });

        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rzut_1.setText("?");
                rzut_2.setText("?");
                rzut_3.setText("?");
                rzut_4.setText("?");
                rzut_5.setText("?");
                wynik_Gry = 0;
                licznik = 0;
                wynik_gry.setText("Wynik gry: " + wynik_Gry);
                liczba_rzutow.setText("Liczba rzutów: " + licznik);
            }
        });

    }

    private void updateScore(int wynik) {
        wynik_Gry +=wynik;
        wynik_gry.setText("Wynik gry: " + wynik_Gry);
    }
}
