package com.insurance.insuranceapp.Activites;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonalAccidentActivity extends AppCompatActivity {
    private TextView title1, file1, filename1;
    private TextView title2, file2, filename2;
    private TextView title3, file3, filename3;
    private TextView title4, file4, filename4;
    private TextView title5, file5, filename5;
    private TextView title6, file6, filename6;
    private TextView title7, file7, filename7;
    private TextView title8, file8, filename8;
    private TextView title9, file9, filename9;
    private TextView title10, file10, filename10;
    private TextView title11, file11, filename11;
    private TextView title12, file12, filename12;
    private TextView title13, file13, filename13;
    private TextView title14, file14, filename14;
    private TextView title15, file15, filename15;
    private TextView title16, file16, filename16;
    private TextView title17, file17, filename17;
    private TextView title18, file18, filename18;
    private TextView title19, file19, filename19;
    private TextView title20, file20, filename20;
    private TextView title21, file21, filename21;
    private TextView title22, file22, filename22;
    private TextView title23, file23, filename23;
    private TextView title24, file24, filename24;
    private TextView title25, file25, filename25;
    private TextView title26, file26, filename26;
    private EditText ed_triggerfinding;
    private EditText ed_comments;
    private EditText ed_date, ed_convance;
    private ImageView calendar;
    private DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    private Button backbutton;


    private String string1 = "<font color='#000000'>Company Authorization Letter towards the hospital </font>" + "<font color='#FF0000'>*</font>";
    private String string2 = "<font color='#000000'>Check List </font>" + "<font color='#FF0000'>*</font>";
    private String string3 = "<font color='#000000'>Claimant Questionnaire Form </font>" + "<font color='#FF0000'>*</font>";
    private String string4 = "<font color='#000000'>Claimant Questionaire </font>" + "<font color='#FF0000'>*</font>";
    private String string5 = "<font color='#000000'>Narration Letter </font>" + "<font color='#FF0000'>*</font>";
    private String string6 = "<font color='#000000'>FIR Copy </font>" + "<font color='#FF0000'>*</font>";
    private String string7 = "Inquest report";
    private String string8 = "Spot Photos";
    private String string9 = "<font color='#000000'>Death Certificate  </font>" + "<font color='#FF0000'>*</font>";
    private String string10 = "<font color='#000000'>Family Photo  </font>" + "<font color='#FF0000'>*</font>";
    private String string11 = "<font color='#000000'>Death Person Photo </font>" + "<font color='#FF0000'>*</font>";
    private String string12 = "<font color='#000000'>Claimant Photo </font>" + "<font color='#FF0000'>*</font>";
    private String string13 = "<font color='#000000'>Income Proof of the Insured  </font>" + "<font color='#FF0000'>*</font>";
    private String string14 = "<font color='#000000'>Bank details(Cancelled Cheaque or passbook first sheet)  </font>" + "<font color='#FF0000'>*</font>";
    private String string15 = "<font color='#000000'>Witness Letter 1 with ID proof </font>" + "<font color='#FF0000'>*</font>";
    private String string16 = "<font color='#000000'>Witness Letter 2 with ID proof </font>" + "<font color='#FF0000'>*</font>";
    private String string17 = "<font color='#000000'>Witness Letter 3 with ID proof </font>" + "<font color='#FF0000'>*</font>";
    private String string18 = "<font color='#000000'>ID proof of Death Person </font>" + "<font color='#FF0000'>*</font>";
    private String string19 = "<font color='#000000'>ID proof of claimant  </font>" + "<font color='#FF0000'>*</font>";
    private String string20 = "Driving License of Death Person";
    private String string21 = "Legal Hair certificate";
    private String string22 = "<font color='#000000'>Cerimination Ground Certificate </font>" + "<font color='#FF0000'>*</font>";
    private String string23 = "Hospital records";
    private String string24 = "RC Book of the vehicle";
    private String string25 = "Others";
    private String string26 = "Evidence for Trigger";
    private String triggerreply = "<font color='#000000'>Trigger Reply </font>" + "<font color='#FF0000'>*</font>";
    private Button submit;
    private String submitted_date = "", triggerfinding = "", comments = "", Convanceamt = "", temp = "";
    private TextInputLayout textInputLayout;
    private List<PendingInfo> pendingInfoList;
    private RelativeLayout relativeLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_cliam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Personal Accident");
        ed_triggerfinding = (EditText) findViewById(R.id.ed_triggers);
        ed_comments = (EditText) findViewById(R.id.ed_comments);
        ed_date = (EditText) findViewById(R.id.edit_date);
        ed_convance = (EditText) findViewById(R.id.ed_convence);
        textInputLayout = (TextInputLayout) findViewById(R.id.input_edit_consult);
        calendar = (ImageView) findViewById(R.id.ig_calender);
        submit = (Button) findViewById(R.id.bt_submit);
        title1 = (TextView) findViewById(R.id.title1);
        title1.setText(Html.fromHtml(string1));
        title2 = (TextView) findViewById(R.id.title2);
        title2.setText(Html.fromHtml(string2));
        title3 = (TextView) findViewById(R.id.title3);
        title3.setText(Html.fromHtml(string3));
        title4 = (TextView) findViewById(R.id.title4);
        title4.setText(Html.fromHtml(string4));
        title5 = (TextView) findViewById(R.id.title5);
        title5.setText(Html.fromHtml(string5));
        title6 = (TextView) findViewById(R.id.title6);
        title6.setText(Html.fromHtml(string6));
        title7 = (TextView) findViewById(R.id.title7);
        title7.setText(string7);
        title8 = (TextView) findViewById(R.id.title8);
        title8.setText(string8);
        title9 = (TextView) findViewById(R.id.title9);
        title9.setText(Html.fromHtml(string9));
        title10 = (TextView) findViewById(R.id.title10);
        title10.setText(Html.fromHtml(string10));
        title11 = (TextView) findViewById(R.id.title11);
        title11.setText(Html.fromHtml(string11));
        title12 = (TextView) findViewById(R.id.title12);
        title12.setText(Html.fromHtml(string12));
        title13 = (TextView) findViewById(R.id.title13);
        title13.setText(Html.fromHtml(string13));
        title14 = (TextView) findViewById(R.id.title14);
        title14.setText(Html.fromHtml(string14));
        title15 = (TextView) findViewById(R.id.title15);
        title15.setText(Html.fromHtml(string15));
        title16 = (TextView) findViewById(R.id.title16);
        title16.setText(Html.fromHtml(string16));
        title17 = (TextView) findViewById(R.id.title17);
        title17.setText(Html.fromHtml(string17));
        title18 = (TextView) findViewById(R.id.title18);
        title18.setText(Html.fromHtml(string18));
        title19 = (TextView) findViewById(R.id.title19);
        title19.setText(Html.fromHtml(string19));
        title20 = (TextView) findViewById(R.id.title20);
        title20.setText(string20);
        title21 = (TextView) findViewById(R.id.title21);
        title21.setText(string21);
        title22 = (TextView) findViewById(R.id.title22);
        title22.setText(Html.fromHtml(string22));
        title23 = (TextView) findViewById(R.id.title23);
        title23.setText(string23);
        title24 = (TextView) findViewById(R.id.title24);
        title24.setText(string24);
        title25 = (TextView) findViewById(R.id.title25);
        title25.setText(string25);
        title26 = (TextView) findViewById(R.id.title26);
        title26.setText(string26);
        backbutton = (Button)findViewById(R.id.bt_back);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitted_date = ed_date.getText().toString();
                if (submitted_date != null && !submitted_date.isEmpty()) {
                    comments = ed_comments.getText().toString();
                    triggerfinding = ed_triggerfinding.getText().toString();
                    Convanceamt = ed_convance.getText().toString();
                } else {
                    textInputLayout.setError("Cannot be empty");
                }
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepicker();

            }
        });

        createEditTextView();


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void createEditTextView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);      //find the linear layout
        linearLayout.removeAllViews();
        relativeLayout = (RelativeLayout) findViewById(R.id.realdynmo);
        pendingInfoList = getList();

        for (int i = 1; i <= pendingInfoList.size(); i++) {

            EditText edittext = new EditText(this);
            TextView title = new TextView(this);
            TextView button = new TextView(this);
            TextView filename = new TextView(this);
            title.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            title.setText("sf" + i);
            edittext.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 160));
            button.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            filename.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            params.setMargins(10, 10, 10, 10);
            Typeface face = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                face = getResources().getFont(R.font.verdana);
            }
            edittext.setTypeface(face);
            title.setTypeface(face);
            button.setTypeface(face);
            filename.setTypeface(face);
            title.setLayoutParams(params);
            button.setLayoutParams(params);
            button.setBackground(getResources().getDrawable(R.drawable.rounded_border_edittext));
            edittext.setInputType(10);
            title.setTextColor(getResources().getColor(R.color.Black));
            edittext.setTextColor(getResources().getColor(R.color.Black));
            button.setTextColor(getResources().getColor(R.color.Black));
            filename.setTextColor(getResources().getColor(R.color.Black));
            edittext.setGravity(Gravity.BOTTOM | Gravity.LEFT);
            edittext.setPadding(5, 5, 5, 5);
            button.setPadding(5, 5, 5, 5);
            filename.setPadding(5, 5, 5, 5);
            edittext.setBackground(getResources().getDrawable(R.drawable.rounded_border_edittext));
            button.setText("Choose File");
            edittext.setTextSize(15f);
            filename.setTextSize(15f);
            edittext.setHint(Html.fromHtml(triggerreply));
            filename.setText("adfd");
            button.setTextSize(17f);
            title.setTextSize(15f);
            linearLayout.addView(title);
            linearLayout.addView(edittext);
            linearLayout.addView(button);
            linearLayout.addView(filename);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "asf", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private List<PendingInfo> getList() {

        pendingInfoList = new ArrayList<>();

        PendingInfo pendingInfo = new PendingInfo();
        pendingInfo.setCliam_no("5461235");
        pendingInfo.setPatient_name("Arun");
        pendingInfo.setCase_type("Hospital Block");
        pendingInfo.setPolicy_number("54322578");
        pendingInfo.setCompany_name("LIC");

        pendingInfo.setCase_assigned_on("Vijila ");

        pendingInfo.setStatus("pending");

        pendingInfoList.add(pendingInfo);


        return pendingInfoList;
    }

    public void datepicker() {
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
            Intent in = new Intent(PersonalAccidentActivity.this, MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
