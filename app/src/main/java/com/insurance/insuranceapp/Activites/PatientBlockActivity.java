package com.insurance.insuranceapp.Activites;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.insurance.insuranceapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PatientBlockActivity extends AppCompatActivity {
    private TextView title1,file1,filename1;
    private TextView title2,file2,filename2;
    private TextView title3,file3,filename3;
    private TextView title4,file4,filename4;
    private TextView title5,file5,filename5;
    private TextView title6,file6,filename6;
    private TextView title7,file7,filename7;
    private TextView title8,file8,filename8;
    private TextView title9,file9,filename9;


    private String string1= "<font color='#000000'>Patient Doctor Questionarie  </font>" + "<font color='#FF0000'>*</font>";
    private String string2= "<font color='#000000'>Patient ID Proof </font>" + "<font color='#FF0000'>*</font>";
    private String string3= "<font color='#000000'>Patient Questionnaire </font>" + "<font color='#FF0000'>*</font>";
    private String string4= "<font color='#000000'>Previous OP and IP records</font>" + "<font color='#FF0000'>*</font>";
    private String string5= "<font color='#000000'>Patient Narration letter </font>" + "<font color='#FF0000'>*</font>";
    private String string6 = "Patient Authorization";
    private String string7 = "Query Reply";
    private String string8 = "Others";
    private String string9 = "Evidence for Trigger";
    private EditText ed_trigger_finding,ed_comments,ed_date,ed_convance;
    private String triggers = "",comments ="",date = "",convance = "",temp ="";
    private ImageView calendar;
    private DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    private TextInputLayout textInputLayout;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_block);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Patient Part");
        ed_trigger_finding =(EditText)findViewById(R.id.ed_triggerfinding);
        textInputLayout = (TextInputLayout)findViewById(R.id.input_edit_consult);
        ed_comments = (EditText)findViewById(R.id.ed_comments);
        ed_date =(EditText)findViewById(R.id.edit_date);
        ed_convance = (EditText)findViewById(R.id.ed_convence);
        calendar = (ImageView)findViewById(R.id.ig_calender);
        title1 = (TextView)findViewById(R.id.title1);
        title1.setText(Html.fromHtml(string1));
        title2 = (TextView)findViewById(R.id.title2);
        title2.setText(Html.fromHtml(string2));
        title3 = (TextView)findViewById(R.id.title3);
        title3.setText(Html.fromHtml(string3));
        title4 = (TextView)findViewById(R.id.title4);
        title4.setText(Html.fromHtml(string4));
        title5 = (TextView)findViewById(R.id.title5);
        title5.setText(Html.fromHtml(string5));
        title6 = (TextView)findViewById(R.id.title6);
        title6.setText(Html.fromHtml(string6));
        title7 = (TextView)findViewById(R.id.title7);
        title7.setText(Html.fromHtml(string7));
        title8 = (TextView)findViewById(R.id.title8);
        title8.setText(Html.fromHtml(string8));
        title9 = (TextView)findViewById(R.id.title9);
        title9.setText(Html.fromHtml(string9));
        submit = (Button)findViewById(R.id.bt_submit);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepicker();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               date= ed_date.getText().toString();
                if(date!=null&& !date.isEmpty()){
                    triggers = ed_trigger_finding.getText().toString();
                    convance = ed_convance.getText().toString();
                    comments = ed_comments.getText().toString();
                }
                else{
                    textInputLayout.setError("Cannot be empty");
                }
            }
        });



    }

    public void datepicker(){
        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        temp = sdf.format(calendar.getTime());
                        ed_date.setText(temp);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home) {
            Intent in = new Intent(PatientBlockActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
