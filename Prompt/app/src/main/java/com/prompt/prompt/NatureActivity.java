package com.prompt.prompt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NatureActivity extends AppCompatActivity {
    private ArrayList text;
    private ArrayList adj;
    private Random num;
    private Random num2;
    private Button refresh;
    private Button help;
    private TextView prompt;
    private int check;
    private int check2;
    private TextView time;
    private Button timeButton;
    private boolean timeOn;
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        time = (TextView) findViewById(R.id.timeTextView2);
        timeButton = (Button) findViewById(R.id.timeButton2);
        timeOn = false;
        timer =  (CountDownTimer) new CountDownTimer(61000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("0!");
            }
        };

        text = new ArrayList(Arrays.asList("Clouds", "Mountains", "Beach", "Hills", "Volcano"
                , "Oasis", "Desert", "Forest", "Rain Puddles", "Starry Sky", "Road"
                , "Lake", "Glaciers", "Fields", "Flower Garden", "Cactus", "Crystal Cave", "Cave", "Fly Trap"
                , "Ferns", "Vines", "Sunflowers", "Meadow", "Burrow", "Den", "Nest", "Tree", "Valley", "Plane"
                , "Cliff", "Chasm", "Canyon", "Pasture", "Tundra", "Biome", "Swamp", "Seafloor", "Garden"));


        adj = new ArrayList(Arrays.asList("Hiding", "Angry", "Sleepy", "Little", "Old", "Spacy"
                , "Beautiful", "Creepy", "Slimy", "Happy", "Scared", "Sad", "Excited", "Dark"
                , "Cold", "Tropical", "Moonlit", "Icy", "Red", "Purple", "Green", "Yellow", "Blue"
                , "Orange", "Sweet", "Cosmic", "Frosty", "Confused", "Serene", "Calm", "Quiet"
                , "Bitter", "Stubborn", "Stormy", "Sick", "Vile", "Gross", "Evil"));

        check = 0;
        check2 = 0;
        prompt = (TextView) findViewById(R.id.natureTextView);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timeOn == true) {
                    timer.start();
                }
                num = new Random();
                int  n = num.nextInt(text.size());
                while (check == n){
                    n = num.nextInt(text.size());
                }
                check = n;
                num2 = new Random();
                int  n2 = num2.nextInt(adj.size());
                while (check2 == n2){
                    n2 = num.nextInt(adj.size());
                }
                check = n2;
                prompt.setText((String) (adj.get(n2) + " " + text.get(n)));
            }
        });

        help = (Button) findViewById(R.id.help3);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NatureActivity.this, HelpActivity.class));
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timeOn == true){
                    timeOn = false;
                    timer.cancel();
                    time.setText("");
                    timeButton.setBackgroundResource(R.drawable.timex);
                } else if (timeOn == false){
                    timeOn = true;
                    timer.start();
                    timeButton.setBackgroundResource(R.drawable.time);
                }
            }
        });
    }
}
