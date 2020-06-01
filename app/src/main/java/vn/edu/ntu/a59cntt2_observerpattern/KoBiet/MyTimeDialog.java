package vn.edu.ntu.a59cntt2_observerpattern.KoBiet;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    Context context1;
    OnMyDateChanceListener onMyDateChanceListener1;
    Calendar calendar1;


    public MyTimeDialog(Context context1, OnMyDateChanceListener onMyDateChanceListener1, Calendar calendar1) {
        this.context1 = context1;
        this.onMyDateChanceListener1 = onMyDateChanceListener1;
        this.calendar1 = calendar1;
    }

    public  void showTimeDialog() {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar1.set(0, 0, 0, hourOfDay, minute);
                if (onMyDateChanceListener1 != null)
                    onMyDateChanceListener1.timeUpdate(calendar1);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context1,
                onTimeSetListener,
                calendar1.get(Calendar.HOUR_OF_DAY),
                calendar1.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }
    public static interface OnMyDateChanceListener
    {
        public void timeUpdate(Calendar newTime);
    }
}



