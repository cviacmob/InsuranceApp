package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.insurance.insuranceapp.R;

public class ProfileActivity extends AppCompatActivity {
    private TableLayout tableLayout,tableLayout_provider;
    private TableRow row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13,row14,row15;
    private TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15;
    private TableRow acc_name,acc_num,bankname,branch,IFSCcode,registereddate,status,remarks;
    private TextView acc_name_text1,acc_num_text2,bankname_text3,branch_text4,IFSCcode_text5,registereddate_text6,status_text7,
            remarks_text8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tableLayout = (TableLayout)findViewById(R.id.tableLayout);
       tableLayout_provider = (TableLayout)findViewById(R.id.tableLayout_provider);

       //Account Information Details
        row1 = (TableRow) tableLayout.getChildAt(0);

        row2 = (TableRow) tableLayout.getChildAt(1);
        row3 = (TableRow) tableLayout.getChildAt(2);
        row4 = (TableRow) tableLayout.getChildAt(3);
        row5 = (TableRow) tableLayout.getChildAt(4);
        row6 = (TableRow) tableLayout.getChildAt(5);
        row7 = (TableRow) tableLayout.getChildAt(6);
        row8 = (TableRow) tableLayout.getChildAt(7);
        row9 = (TableRow) tableLayout.getChildAt(8);
        row10 = (TableRow) tableLayout.getChildAt(9);
        row11 = (TableRow) tableLayout.getChildAt(10);
        row12 = (TableRow) tableLayout.getChildAt(11);
        row13 = (TableRow) tableLayout.getChildAt(12);
        row14 = (TableRow) tableLayout.getChildAt(13);
        row15 = (TableRow) tableLayout.getChildAt(14);

        text1 =(TextView)row1.getChildAt(1);
        text2 =(TextView)row2.getChildAt(1);
        text3 =(TextView)row3.getChildAt(1);
        text4 =(TextView)row4.getChildAt(1);
        text5 =(TextView)row5.getChildAt(1);
        text6 =(TextView)row6.getChildAt(1);
        text7 =(TextView)row7.getChildAt(1);
        text8 =(TextView)row8.getChildAt(1);
        text9 =(TextView)row9.getChildAt(1);
        text10 =(TextView)row10.getChildAt(1);
        text11 =(TextView)row11.getChildAt(1);
        text12 =(TextView)row12.getChildAt(1);
        text13 =(TextView)row13.getChildAt(1);
        text14 =(TextView)row14.getChildAt(1);
        text15 =(TextView)row15.getChildAt(1);

        //provider details
        acc_name = (TableRow) tableLayout_provider.getChildAt(0);
        acc_num = (TableRow) tableLayout_provider.getChildAt(1);
        bankname = (TableRow) tableLayout_provider.getChildAt(2);
        branch = (TableRow) tableLayout_provider.getChildAt(3);
        IFSCcode = (TableRow) tableLayout_provider.getChildAt(4);
        registereddate = (TableRow) tableLayout_provider.getChildAt(5);
        status = (TableRow) tableLayout_provider.getChildAt(6);
        remarks = (TableRow) tableLayout_provider.getChildAt(7);

        acc_name_text1 =(TextView)acc_name.getChildAt(1);
        acc_num_text2 =(TextView)acc_num.getChildAt(1);
        bankname_text3 =(TextView)bankname.getChildAt(1);
        branch_text4 =(TextView)branch.getChildAt(1);
        IFSCcode_text5 =(TextView)IFSCcode.getChildAt(1);
        registereddate_text6 =(TextView)registereddate.getChildAt(1);
        status_text7 =(TextView)status.getChildAt(1);
        remarks_text8 =(TextView)remarks.getChildAt(1);
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
            Intent in = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }


}
