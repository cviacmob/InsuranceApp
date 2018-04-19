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
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HospitalBlockActivity extends AppCompatActivity {

    private TextView title1,file1,filename1;
    private TextView title2,file2,filename2;
    private TextView title3,file3,filename3;
    private TextView title4,file4,filename4;
    private TextView title5,file5,filename5;
    private TextView title6,file6,filename6;
    private TextView title7,file7,filename7;
    private TextView title8,file8,filename8;
    private TextView title9,file9,filename9;
    private TextView title10,file10,filename10;
    private TextView title11,file11,filename11;
    private TextView title12,file12,filename12;
    private TextView title13,file13,filename13;
    private TextView title14,file14,filename14;
    private TextView title19,file19,filename19;
    private String string1= "<font color='#000000'>Company Authorization Letter towards the hospital </font>" + "<font color='#FF0000'>*</font>";
    private String string2= "<font color='#000000'>Investigation report form </font>" + "<font color='#FF0000'>*</font>";
    private String string3= "<font color='#000000'>Treating doctor Questionnaire </font>" + "<font color='#FF0000'>*</font>";
    private String string4= "<font color='#000000'>Case sheet </font>" + "<font color='#FF0000'>*</font>";
    private String string5= "<font color='#000000'>Doctor Questionnaire </font>" + "<font color='#FF0000'>*</font>";
    private String string6 = "IP register";
    private String string7 = "Lab Register";
    private String string8 = "Final Bill";
    private String string9 = "Previous OP and IP records";
    private String string10 = "<font color='#000000'>Field Investigation report </font>" + "<font color='#FF0000'>*</font>";

    private String string11= "Hospital Snaps";
    private String string12= "Others";
    private String string13= "Medical Records Bill (if any)";
    private String string14= "Evidence for Trigger";
    private String string19= "Conveyance File(s)";
    private String triggerreply = "<font color='#000000'>Trigger Reply </font>" + "<font color='#FF0000'>*</font>";
    private ListView triggerlist;
    private Button bt_next;
    private Button save,submit,back;
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingInfo> pendingInfoList;
    private RelativeLayout relativeLayout;
    private EditText ed_comments,ed_date,ed_convoy,ed_mrd;
    private String Comments = "",Submitted_date = "",temp = "",conveyance = "",MRD = "";
    private ImageView calendar;
    private DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    private TextInputLayout textInputLayout;
    private Button button;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_block);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hospital Part Block");
        textInputLayout = (TextInputLayout)findViewById(R.id.input_edit_consult);
        calendar = (ImageView)findViewById(R.id.ig_calender);
        ed_convoy = (EditText)findViewById(R.id.famildoc);
        ed_mrd = (EditText)findViewById(R.id.famildoc1);
        save = (Button)findViewById(R.id.care_save);
        submit = (Button)findViewById(R.id.bt_submit);

        back = (Button)findViewById(R.id.bt_back);
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
        title10 = (TextView)findViewById(R.id.title10);
        title10.setText(Html.fromHtml(string10));
        title11 = (TextView)findViewById(R.id.title11);
        title11.setText(Html.fromHtml(string11));
        title12 = (TextView)findViewById(R.id.title12);
        title12.setText(Html.fromHtml(string12));
        title13 = (TextView)findViewById(R.id.title13);
        title13.setText(Html.fromHtml(string13));
        title14 = (TextView)findViewById(R.id.title14);
        title14.setText(Html.fromHtml(string14));
        title19 = (TextView)findViewById(R.id.title19);
        title19.setText(Html.fromHtml(string19));
        ed_comments = (EditText)findViewById(R.id.ed_family);
        ed_date = (EditText)findViewById(R.id.edit_consult);





        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepicker();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Submitted_date = ed_date.getText().toString();
                if(Submitted_date!=null && !Submitted_date.isEmpty()){
                    Comments = ed_comments.getText().toString();
                MRD = ed_mrd.getText().toString();
                conveyance = ed_convoy.getText().toString();

                }else{
                    textInputLayout.setError("Cannot be empty");
                }
            }
        });

        createEditTextView();


   /*     pendingInfoList =  getList();
        pendingcaseAdapter = new PendingCasesAdapter(pendingInfoList,this.getApplication());

        triggerlist.setAdapter(pendingcaseAdapter);*/
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void createEditTextView() {
        LinearLayout linearLayout= (LinearLayout)findViewById(R.id.linear);      //find the linear layout
        linearLayout.removeAllViews();
        relativeLayout = (RelativeLayout)findViewById(R.id.realdynmo);
        pendingInfoList =  getList();

        for(int i=1;i<=pendingInfoList.size();i++) {

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
                    Toast.makeText(getApplicationContext(),"asf",Toast.LENGTH_SHORT).show();
                }
            });
        }
        }
    private List<PendingInfo> getList(){

        pendingInfoList = new ArrayList<>();

        PendingInfo pendingInfo = new PendingInfo();
        pendingInfo.setClaim_no("5461235");
        pendingInfo.setPatientName("Arun");
        pendingInfo.setBlock_name("Hospital Block");
        pendingInfo.setPolicy_no("54322578");
        pendingInfo.setInsurance_company("LIC");
        pendingInfo.setCase_name("Hospital Part");
        pendingInfo.setAssigned_to("Vijila ");
        pendingInfo.setCase_assigned_on("05-04-2018");
        pendingInfo.setStatus("pending");

        pendingInfoList.add(pendingInfo);

        PendingInfo pendingInfo1 = new PendingInfo();
        pendingInfo1.setClaim_no("5461236");
        pendingInfo1.setPatientName("Varun");
        pendingInfo1.setBlock_name("Hospital Block");
        pendingInfo1.setPolicy_no("54322579");
        pendingInfo1.setInsurance_company("LIC");
        pendingInfo1.setCase_name("Hospital Part");
        pendingInfo1.setAssigned_to("Vijila");
        pendingInfo1.setCase_assigned_on("06-04-2018");
        pendingInfo1.setStatus("pending");
        pendingInfoList.add(pendingInfo1);
        return pendingInfoList;
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
            Intent in = new Intent(HospitalBlockActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
