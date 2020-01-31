package com.example.mnallamalli97.speedread;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private long seekBarValue;
    private SeekBar seekBar;
    private Button saveButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();


        saveButton = findViewById(R.id.saveButton);
        seekBar = findViewById(R.id.seekBar);
        resultText =findViewById(R.id.resultText);


        seekBar.setProgress((int) pref.getLong("speedReadSpeed", -1));
        String speedString = String.valueOf(pref.getLong("speedReadSpeed", -1));
        resultText.setText(speedString);
        seekBar.setMax(1000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                resultText.setText(seekBarValue + "");

                editor.putLong("speedReadSpeed",seekBarValue);
                editor.apply();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(SettingsActivity.this, MainActivity.class);
                Bundle extras = new Bundle();
                extras.putLong("speedreadSpeed", seekBarValue);

                startIntent.putExtras(extras);
                startActivity(startIntent);
            }
        });

    }
}
