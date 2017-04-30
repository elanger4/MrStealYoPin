package com.jim_cares.platgrp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //accelerometer present
        if(senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            //we don't have an accelerometer, and we need to error out somehow
            MainActivity.this.finish();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent senEvent) {
        Sensor mySensor = senEvent.sensor;

        //get action for key press
        boolean down = eventAction();

        //if keypress, store the accelerometer data
        if(down) {
            if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float x = senEvent.values[0];
                float y = senEvent.values[1];
                float z = senEvent.values[2];
                try {
                    commitToFile(Float.toString(x), Float.toString(y), Float.toString(z));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean eventAction() {
        KeyEvent kEvent = null;
        return kEvent.getAction() == KeyEvent.ACTION_DOWN;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    //register listener for event listening
    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //unregister listener to preserve battery
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    private void commitToFile(String x, String y,
                              String z) throws IOException {
        final String entryString = new String(x + " " + y + " " + z);

        FileOutputStream fOut = openFileOutput("savedData.txt", MODE_APPEND);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        osw.write(entryString);
        osw.flush();
        osw.close();
    }
}
