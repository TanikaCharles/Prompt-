package com.prompt.prompt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button landscape;
    private Button animals;
    private Button people;
    private Button help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        landscape = (Button) findViewById(R.id.landscape);
        animals = (Button) findViewById(R.id.animals);
        people = (Button) findViewById(R.id.people);
        help = (Button) findViewById(R.id.help);

        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NatureActivity.class));
            }
        });

        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnimalsActivity.class));
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PeopleActivity.class));
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });
    }
}
