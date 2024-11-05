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
    private TextView rzut1;
    private TextView rzut2;
    private TextView rzut3;
    private TextView rzut4;
    private TextView rzut5;
    private TextView tytul;
    private TextView wynik_losowania;
    private TextView wynik_gry;
    private TextView liczba_rzutow;
    private Random ra = new Random();
    int wynik_Gry = 0;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzut1 = findViewById(R.id.rzut1);
        rzut2 = findViewById(R.id.rzut2);
        rzut3 = findViewById(R.id.rzut3);
        rzut4 = findViewById(R.id.rzut4);
        rzut5 = findViewById(R.id.rzut5);
        tytul = findViewById(R.id.tytul);
        wynik_gry = findViewById(R.id.wynik_gry);
        wynik_losowania = findViewById(R.id.wynik_losowania);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);
        button_rzut = findViewById(R.id.button_rzut);
        button_reset = findViewById(R.id.button_reset);

        button_rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rad1 = ra.nextInt(6) + 1;
                rzut1.setText(Integer.toString(rad1));
                int rad2 = ra.nextInt(6) + 1;
                rzut2.setText(Integer.toString(rad2));
                int rad3 = ra.nextInt(6) + 1;
                rzut3.setText(Integer.toString(rad3));
                int rad4 = ra.nextInt(6) + 1;
                rzut4.setText(Integer.toString(rad4));
                int rad5 = ra.nextInt(6) + 1;
                rzut5.setText(Integer.toString(rad5));


                int[] liczby = {rad1, rad2, rad3, rad4, rad5};
                int wynik = 0;
                int[] count = new int[6]; // Assuming the numbers are between 1 and 6

                // Count the occurrences of each number
                for (int i = 0; i < liczby.length; i++) {
                    count[liczby[i] - 1]++;
                }

                // Calculate the score based on the occurrences
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
                rzut1.setText("?");
                rzut2.setText("?");
                rzut3.setText("?");
                rzut4.setText("?");
                rzut5.setText("?");
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
