package com.example.audioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
       public void Start(View view) {
          mediaPlayer.start();
          }
    public void Pause(View view) {
          mediaPlayer.pause();
    }
            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentValue= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
              mediaPlayer = MediaPlayer.create(this, R.raw.heavyrain);
                SeekBar volumeControl= (SeekBar) findViewById(R.id.volumeSeekBar);
                volumeControl.setMax(maxVolume);
                volumeControl.setProgress(currentValue);
                volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Seekbar Changed",Integer.toString(i));
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i,0 );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                Seekbar scrubSeekBar= (Seekbar) findViewById (R.id.scrubSeekBar);

                 }
}
