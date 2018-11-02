package com.camera.sample.controls;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

public class ControlsFragment extends Fragment implements SensorEventListener {

    private SensorManager mSensorManager;

    private Sensor mLight;

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {

//        view.findViewById(R.id.info).setOnClickListener(this);

        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            Log.d("[sample-app]", "light: " + event.values[0]);
            final float currentReading = event.values[0];
            Log.d("[sample-app]", "" + (int) currentReading);
            Log.d("[sample-app]", "" + "Current Reading(Lux): " + String.valueOf(currentReading));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();
    }
}
