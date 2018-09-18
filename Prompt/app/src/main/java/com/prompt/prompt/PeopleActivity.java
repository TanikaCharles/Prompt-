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

public class PeopleActivity extends AppCompatActivity {
    private ArrayList text;
    private ArrayList adj;
    private int check;
    private int check2;
    private TextView prompt;
    private Button refresh;
    private Button help;
    private Random num;
    private Random num2;
    private TextView time;
    private Button timeButton;
    private boolean timeOn;
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        time = (TextView) findViewById(R.id.timeTextView3);
        timeButton = (Button) findViewById(R.id.timeButton3);
        timeOn = false;
        timer =  (CountDownTimer) new CountDownTimer(61000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("0!");
            }
        };

        text = new ArrayList(Arrays.asList("Woman", "Man", "Girl", "Boy", "Old Woman", "Old Man"
                , "Fairy", "Knight", "Dentist", "Soldier", "Queen", "Doctor", "Salesman", "Scientist"
                , "Engineer", "Alchemist", "Guru", "Witch", "Samurai", "Ghost", "Hacker", "Cyborg"
                , "Cyclist", "Angel", "Goth", "Monk", "Mother", "Father", "Twins", "Scuba Diver"
                , "Chemist", "Artist", "Writer", "Chef", "Hipster", "Musician", "Technician"
                ,"Prisoner", "Guard", "President", "Surgeon", "Astronaut", "Inquisitor", "Priest"
                , "Bride", "Groom", "Hiker", "Camper", "Swimmer", "Actor", "Singer", "Rapper"
                , "Judge", "Executioner", "Body Guard", "Prophet"));

        adj = new ArrayList(Arrays.asList("Hiding", "Angry", "Sleepy", "Little", "Old", "Spacy"
                , "Beautiful", "Creepy", "Slimy", "Happy", "Scared", "Sad", "Excited", "Dark"
                , "Cold", "Tropical", "Moonlit", "Icy", "Red", "Purple", "Green", "Yellow", "Blue"
                , "Orange", "Sweet", "Cosmic", "Frosty", "Confused", "Serene", "Calm", "Quiet"
                , "Bitter", "Stubborn", "Stormy", "Sick", "Vile", "Gross", "Evil"));

        check = 0;
        check2 = 0;
        prompt = (TextView) findViewById(R.id.peopleTextView);
        refresh = (Button) findViewById(R.id.peopleRefresh);
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

        help = (Button) findViewById(R.id.help4);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PeopleActivity.this, HelpActivity.class));
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
