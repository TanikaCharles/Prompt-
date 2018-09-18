package com.prompt.prompt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    private TextView helpText;
    private TextView refreshText;
    private TextView timerText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        helpText = (TextView) findViewById(R.id.helpText);
        helpText.setText(R.string.help);
        refreshText = (TextView) findViewById(R.id.refreshText);
        refreshText.setText(R.string.help_refresh);
        timerText = (TextView) findViewById(R.id.timerText);
        timerText.setText(R.string.help_timer);
    }
}
