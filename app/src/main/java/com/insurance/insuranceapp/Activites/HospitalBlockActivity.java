package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalBlockActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
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
    private ListView triggerlist;
    private Button bt_next;
    private Button save,submit,back;
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingInfo> pendingInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_block);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hospital Part Block");
        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01);
        bt_next = (Button) findViewById(R.id.care_next);
      //  triggerlist = (ListView)findViewById(R.id.triggerlist);
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


        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewFlipper.showNext();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               viewFlipper.showPrevious();
            }
        });

      /*  pendingInfoList =  getList();
        pendingcaseAdapter = new PendingCasesAdapter(pendingInfoList,this.getApplication());
        triggerlist.setDivider(null);
        triggerlist.setAdapter(pendingcaseAdapter);
*/
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
