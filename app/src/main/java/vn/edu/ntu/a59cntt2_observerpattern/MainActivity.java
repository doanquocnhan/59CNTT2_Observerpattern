package vn.edu.ntu.a59cntt2_observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import vn.edu.ntu.a59cntt2_observerpattern.KoBiet.MyDateDialog;
import vn.edu.ntu.a59cntt2_observerpattern.KoBiet.MyTimeDialog;

public class MainActivity extends AppCompatActivity implements
        MyDateDialog.OnMyDateChanceListener {

EditText editDate,editTime;
ImageView imageView,imageTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }
    private void addView()
    {
        editDate =findViewById(R.id.editData);
        editDate.setEnabled(false);
        imageView = findViewById(R.id.imageView);
        editTime =(EditText) findViewById(R.id.editTime);
        editTime.setEnabled(false);
        imageTime = findViewById(R.id.imageTime);
    }
    private  void addEvent() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog dateDialog = new MyDateDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                dateDialog.showDateDialog();

            }
        });
        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog myTimeDialog = new MyDateDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance()
                );
                myTimeDialog.showTimeDialog();
            }
        });

    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder = new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(Calendar.MONTH))
                .append("/")
                .append(newDate.get(Calendar.YEAR));
        editDate.setText(builder.toString());
    }

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY))
                .append(":")
                .append(newTime.get(Calendar.MINUTE));
        editTime.setText(builder.toString());
    }
}
