package com.example.cwiczenie3_3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams lnrlayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Resources res = getResources();

        for(int i = 0; i <= 7; i++) {
            TextView tV = new TextView(this);

            int min = 1;
            int max = 99;

            int rand = (int)Math.floor(Math.random() * (max-min+1) + min);

            tV.setLayoutParams(layout);
            setContentView(linearLayout, lnrlayout);

            String textStr = res.getQuantityString(R.plurals.sztuki, rand);

            linearLayout.addView(tV);

            int[] allColors = res.getIntArray(R.array.newcolors);
            int getColorVar = allColors[new Random().nextInt(allColors.length)];

            tV.setTextColor(getColorVar);

            tV.setText(" " + rand + "\n" + textStr + " \n");
        }
    }
}