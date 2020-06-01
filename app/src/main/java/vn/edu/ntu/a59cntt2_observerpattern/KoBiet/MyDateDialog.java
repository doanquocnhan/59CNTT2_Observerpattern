package vn.edu.ntu.a59cntt2_observerpattern.KoBiet;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyDateDialog
{
    Context context;
    OnMyDateChanceListener onMyDateChanceListener;
    Calendar calendar;


    public MyDateDialog(Context context, OnMyDateChanceListener onMyDateChanceListener, Calendar calendar) {
        this.context = context;
        this.onMyDateChanceListener = onMyDateChanceListener;
        this.calendar = calendar;
    }

    public  void showDateDialog()
    {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                calendar.set(year, month, dayOfMonth);
                if(onMyDateChanceListener !=null)
                onMyDateChanceListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
                );
        datePickerDialog.show();
    }
    public  void showTimeDialog() {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0, 0, 0, hourOfDay, minute);
                if (onMyDateChanceListener != null)
                    onMyDateChanceListener.timeUpdate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }

    public  static interface OnMyDateChanceListener
    {
        public  void dateUpdate(Calendar newDate);
        public  void timeUpdate(Calendar newTime);
    }
}
