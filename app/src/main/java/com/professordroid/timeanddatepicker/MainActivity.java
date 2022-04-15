package com.professordroid.timeanddatepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTime, textViewDate;

    interface TimeInterface {
        void onTimeSet(String time);
    }

    interface DateInterface {
        void onDateSet(String date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTime = findViewById(R.id.textViewTime);
        textViewDate = findViewById(R.id.textViewDate);
    }

    public void showTimeFragment(View view) {
        DialogFragment timeFragment = new TimePickeFragment(new TimeInterface() {
            @Override
            public void onTimeSet(String time) {
                textViewTime.setText(time);
            }
        });
        timeFragment.show(getSupportFragmentManager(), timeFragment.getClass().getSimpleName());
    }


    public void showDateFragment(View view) {
        DialogFragment timeFragment = new DatePickerFragment(new DateInterface() {
            @Override
            public void onDateSet(String date) {
                textViewDate.setText(date);
            }
        });
        timeFragment.show(getSupportFragmentManager(), timeFragment.getClass().getSimpleName());
    }
}