package com.kaungkhantlynn.testingtab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import model.Todo;

public class AddTask extends AppCompatActivity implements

        DatePickerDialog.OnDateSetListener
{
    Toolbar toolbar;
    TextView txtDate;
    Button btnDate;
    Button done;
    EditText inputText;
    String date;
    int mYear;
    int mMonth;
    int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnDate=(Button)findViewById(R.id.btndate);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Calendar c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);
        String currentDate = day+"/"+month+"/"+year;

        txtDate=(TextView)findViewById(R.id.dateview);
        txtDate.setText(currentDate);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        AddTask.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        done=(Button)findViewById(R.id.btn_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText=(EditText)findViewById(R.id.input);
                String inputData=inputText.getText().toString();
                Todo todo=new Todo(inputData,date,mYear,mMonth,mDay);
                todo.save();

                onBackPressed();
            }
        });
    }



    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        date = dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        mYear=year;
        mMonth=monthOfYear;
        mDay=dayOfMonth;

        txtDate=(TextView)findViewById(R.id.dateview);
       txtDate.setText(date);
    }

    @Override
    public void onResume() {
        super.onResume();

        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
    }
}