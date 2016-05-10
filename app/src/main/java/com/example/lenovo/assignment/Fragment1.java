package com.example.lenovo.assignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class Fragment1 extends Fragment implements View.OnClickListener {

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    TimePicker timePicker;
    public static Fragment1 inst;
    private TextView alarmTextView;



    public static Fragment1 instance()
    {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        alarmTextView = (TextView) view.findViewById(R.id.alarmTextView);


        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);


        return view;

    }

    public void setAlarmText(String alarmText)
    {
        alarmTextView.setText(alarmText);

    }




    @Override
    public void onClick(View v)
    {

            Toast.makeText(getActivity().getApplicationContext(),"Time  Saved ",Toast.LENGTH_LONG).show();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
            Intent myintent = new Intent(getActivity().getApplicationContext(),Alarm.class);
            pendingIntent = PendingIntent.getBroadcast(getContext(),0,myintent,0);
            alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);




    }
}
