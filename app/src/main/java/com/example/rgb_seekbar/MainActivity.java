package com.example.rgb_seekbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements SeekBar.OnSeekBarChangeListener{

    SeekBar red,green,blue;
    TextView redv,greenv,bluev,hex,color;
    int r=0,g=0,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red=(SeekBar)findViewById(R.id.red);
        green=(SeekBar)findViewById(R.id.green);
        blue=(SeekBar)findViewById(R.id.blue);
      //  hex=(TextView)findViewById(R.id.hex);
        color=(TextView)findViewById(R.id.color);
        redv=(TextView)findViewById(R.id.redV);
        greenv=(TextView)findViewById(R.id.greenV);
        bluev=(TextView)findViewById(R.id.blueV);

        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);

        if (savedInstanceState != null)
        {
            r = savedInstanceState.getInt("r");
            g = savedInstanceState.getInt("g");
            b = savedInstanceState.getInt("b");


        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId())
        {
            case R.id.red:
                r=progress;
                break;
            case R.id.green:
                g=progress;
                break;
            case R.id.blue:
                b=progress;
                break;

        }
      //  String c=colorHex(r,g,b);
      //  hex.setText("HEX: "+c);
        color.setBackgroundColor(android.graphics.Color.rgb(r,g,b));

    }

    public String colorHex(int r,int b, int g)
    {
        String color="";
        color="#";
      //  color+=Integer.toHexString(r);
       // color+=Integer.toHexString(g);
      //  color+=Integer.toHexString(b);
        return color;
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        redv.setText("R: "+r);
        greenv.setText("G: "+g);
        bluev.setText("B: "+b);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        redv.setText("R: "+r);
        greenv.setText("G: "+g);
        bluev.setText("B: "+b);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("r", r);
        outState.putInt("g", g);
        outState.putInt("b", b);

    }

}
