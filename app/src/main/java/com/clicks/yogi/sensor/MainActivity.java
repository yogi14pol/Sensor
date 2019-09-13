package com.clicks.yogi.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt1.setVisibility(View.VISIBLE);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        assert sensorManager != null;
        List<Sensor> mList= sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i<mList.size();i++) {
            txt1.setVisibility(View.VISIBLE);
            txt1.append("\n" + mList.get(i).getName() + "\n" +
                    mList.get(i).getVendor()+"\n");
        }
    }
}