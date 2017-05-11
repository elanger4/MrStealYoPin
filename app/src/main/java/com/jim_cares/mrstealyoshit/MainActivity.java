package com.jim_cares.mrstealyoshit;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.lang.String;

import com.jim_cares.mrstealyoshit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public class AccelData {
        final double x;
        final double y;
        final double z;
        public AccelData (double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    Vector<AccelData> vct = new Vector<AccelData>();
    boolean keyPress = false;

    private ActivityMainBinding binding;
    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        findViewById(R.id.buttonZero).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonOne).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonTwo).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonThree).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonFour).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonFive).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonSix).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonSeven).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonEight).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonNine).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonClear).setOnClickListener(mGlobal_OnClickListener);
        findViewById(R.id.buttonAccept).setOnClickListener(mGlobal_OnClickListener);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    };

    final OnClickListener mGlobal_OnClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()) {
                case R.id.buttonZero:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "0");
                break;
                case R.id.buttonOne:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "1");
                break;
                case R.id.buttonTwo:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "2");
                break;
                case R.id.buttonThree:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "3");
                break;
                case R.id.buttonFour:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "4");
                break;
                case R.id.buttonFive:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "5");
                break;
                case R.id.buttonSix:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "6");
                break;
                case R.id.buttonSeven:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "7");
                break;
                case R.id.buttonEight:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "8");
                break;
                case R.id.buttonNine:
                    keyPress = true;
                    binding.editText.setText(binding.editText.getText() + "9");
                break;
                case R.id.buttonClear:
                    //remove prior key press from display
                    Editable tmp = binding.editText.getText();

                    if(tmp.length() > 0) {
                        tmp.delete(tmp.length() - 1, tmp.length());
                    }
                    binding.editText.setText((tmp));

                    //remove prior key press from output vector
                    vct.removeElementAt(vct.size() - 1);
                break;
                case R.id.buttonAccept:
                    // implement method to accept the input on the keypad
                    try {
                        onAccept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // implement method to clear the screen
                    binding.editText.setText("");
            }
        }
    };

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //unused, necessary for the implementation of SensorEventListener
    }

    public void onSensorChanged(SensorEvent event) {
        if(keyPress) {
            keyPress = false;
            if (vct.isEmpty()) {
                AccelData tmp = new AccelData(event.values[0], event.values[1], event.values[2]);
                vct.add(tmp);
            } else {
                AccelData tmp = vct.lastElement();
                AccelData tmp2 = new AccelData(event.values[0] - tmp.x, event.values[1] - tmp.y, event.values[2] - tmp.z);
                vct.add(tmp2);
            }
        }
    }

    public void onAccept() throws IOException {
        while(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

        if(isExternalStorageWritable()) {
            File root = new File(String.valueOf(Environment.getExternalStorageDirectory()), "testData");
            root.mkdirs();
            File file = new File(root, "testData.txt");

            if(!file.exists()) {
                file.createNewFile();
            }

            try {
                FileOutputStream f = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(f);

                for(int i = 0; i < vct.size(); i++) {
                    pw.print(vct.get(i).x);
                    pw.append("    ");
                    pw.print(vct.get(i).y);
                    pw.append("    ");
                    pw.print(vct.get(i).z);
                    pw.print(System.getProperty("line.separator"));
                }
                pw.flush();
                pw.close();
                f.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}