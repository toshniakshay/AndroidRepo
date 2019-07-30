package com.example.myfirstapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Counter extends AppCompatActivity {
    private Button btn_increment;
    private Button btn_decrement;
    private TextView textView_counter;
    private int nCounter = 0;


    MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        textView_counter = findViewById(R.id.et_counter);
        textView_counter.setText(String.valueOf(nCounter));
        btn_increment = findViewById(R.id.btn_increment);
        btn_decrement = findViewById(R.id.btn_decrement);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uri);
        mediaPlayer.start();

        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nCounter++;
                String n=String.valueOf(nCounter);
                textView_counter.setText(n);
            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(textView_counter.getText().toString()) > 0) {
                    nCounter--;
                    String n=String.valueOf(nCounter);
                    textView_counter.setText(n);
                } else {
                    Toast t = Toast.makeText(Counter.this, "Counter is 0 can't Decrement the value of the counter", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}


