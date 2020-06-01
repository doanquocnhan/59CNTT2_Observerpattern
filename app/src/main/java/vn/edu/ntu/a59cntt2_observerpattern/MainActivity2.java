package vn.edu.ntu.a59cntt2_observerpattern;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import vn.edu.ntu.a59cntt2_observerpattern.KoBiet.MyDateDialog;
import vn.edu.ntu.a59cntt2_observerpattern.KoBiet.MyTimeDialog;

public class MainActivity2 extends AppCompatActivity implements
        MyTimeDialog.OnMyDateChanceListener {
    EditText editTime;
    ImageView imageTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addView() {

        editTime = (EditText) findViewById(R.id.editTime);
        editTime.setEnabled(false);
        imageTime = findViewById(R.id.imageTime);
    }

    private void addEvent() {
        imageTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog myTimeDialog = new MyTimeDialog(
                        MainActivity2.this,
                        MainActivity2.this,
                        Calendar.getInstance()
                );
                myTimeDialog.showTimeDialog();
            }
        });
    }

    ;

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY))
                .append("/")
                .append(newTime.get(Calendar.MINUTE));
        editTime.setText(builder.toString());
    }
}




