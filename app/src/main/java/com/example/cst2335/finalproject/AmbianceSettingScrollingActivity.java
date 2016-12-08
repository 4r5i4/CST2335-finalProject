package com.example.cst2335.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AmbianceSettingScrollingActivity extends AppCompatActivity {

    private static final String LOGIN_ACTIVITY = "AmbianceSettingScrollingActivity";
    public static final String LIGHTBAR_SEEKBAR = "LIGHTBAR_KEY";
    private static final String TEMP_SEEKBAR = "TEMP_SEEKBAR";
    ImageView speakerImage;
    SeekBar lightSeekBar;
    SeekBar tempSeekBar;
    TextView temptv;
    TextView lighttv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambiance_setting_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Go back to home screen?", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.GREEN)
                        .setDuration(Snackbar.LENGTH_LONG)
                        .setAction("YES!", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(AmbianceSettingScrollingActivity.this,
                                        MainActivity.class);
                                startActivityForResult(intent, 55);
                            }
                        }).show();
            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Setting up the tabs of the TabWidget
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("°C");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Light");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Audio");
        host.addTab(spec);

/*        ToggleSpeaker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("speaker on");
                speakerImage = (ImageView) findViewById(R.id.speakers);
                speakerImage.setAlpha((float) 0.3);
            }
        });*/

        temptv = (TextView) findViewById(R.id.TemperatureTextview);
        lighttv = (TextView) findViewById(R.id.lightPercentageTextview);

        speakerImage = (ImageView) findViewById(R.id.speakers);
        speakerImage.setAlpha((float) 0.3);
        final ToggleButton ToggleSpeaker = (ToggleButton) findViewById(R.id.KitchenSpeakersToggleButton);
        ToggleSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ToggleSpeaker.isChecked()) {
                    speakerImage.setAlpha((float) 1.0);
                    Toast.makeText(AmbianceSettingScrollingActivity.this,
                            "Speakers are ON", Toast.LENGTH_SHORT).show();
                } else {
                    speakerImage.setAlpha((float) 0.3);
                    Toast.makeText(AmbianceSettingScrollingActivity.this,
                            "Speakers are OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tempSeekBar = (SeekBar) findViewById(R.id.KickenThermostatSeekbar);
        tempSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SharedPreferences prefs = getSharedPreferences(LOGIN_ACTIVITY, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                int et_temp_bar = tempSeekBar.getProgress();
                editor.putInt(TEMP_SEEKBAR, et_temp_bar);
                editor.apply();

                temptv.setText(String.valueOf(et_temp_bar));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        lightSeekBar = (SeekBar) findViewById(R.id.KitchenLightsToggleSeekbar);
        lightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SharedPreferences prefs = getSharedPreferences(LOGIN_ACTIVITY, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                int et_light_bar = lightSeekBar.getProgress();
                editor.putInt(LIGHTBAR_SEEKBAR, et_light_bar);
                editor.apply();

                lighttv.setText(String.valueOf(et_light_bar * 2));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = getSharedPreferences(LOGIN_ACTIVITY, Context.MODE_PRIVATE);
        int defult_light_seekbar_prgress = preferences.getInt(LIGHTBAR_SEEKBAR, 25);
        int defult_temperature_progress = preferences.getInt(TEMP_SEEKBAR, 25);
        lightSeekBar.setProgress(defult_light_seekbar_prgress);
        tempSeekBar.setProgress(defult_temperature_progress);
        temptv.setText(String.valueOf(defult_temperature_progress));
        lighttv.setText(String.valueOf(defult_light_seekbar_prgress));

    }
}
