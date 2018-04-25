package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.insurance.insuranceapp.R;

public class ReservedPaymentsActivity extends AppCompatActivity {
    private int mode;
    private TableLayout tableLayout;
    private TableRow row1,row2,row3,row4,row5,row6,row7,row9;
    private TextView claim_number,patientname,blockname,TAT,TA,MRD,incentive,totalamt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_payments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       mode =  getIntent().getIntExtra("Payments",0);
        tableLayout = (TableLayout)findViewById(R.id.tableLayout);
        row1 = (TableRow) tableLayout.getChildAt(0);

        row2 = (TableRow) tableLayout.getChildAt(1);
        row3 = (TableRow) tableLayout.getChildAt(2);
        row4 = (TableRow) tableLayout.getChildAt(3);
        row5 = (TableRow) tableLayout.getChildAt(4);
        row6 = (TableRow) tableLayout.getChildAt(5);
        row7 = (TableRow) tableLayout.getChildAt(6);

        row9 = (TableRow) tableLayout.getChildAt(7);

        claim_number =(TextView)row1.getChildAt(1);
        patientname =(TextView)row2.getChildAt(1);
        blockname =(TextView)row3.getChildAt(1);
        TAT =(TextView)row4.getChildAt(1);
        incentive =(TextView)row5.getChildAt(1);
        TA =(TextView)row6.getChildAt(1);
        MRD =(TextView)row7.getChildAt(1);
        totalamt =(TextView)row9.getChildAt(1);

       if(mode==1){
           setTitle("Confirmed Payments");
           text_values();

       }else if(mode == 2){
           setTitle("Reserved Payments");
           text_values();
       }



    }


    private void text_values(){
        claim_number.setText("2564235");
        patientname.setText("Arun");
        blockname.setText("Hospital Block");
        TAT.setText("12");
        incentive.setText("Rs.600");
        TA.setText("Rs.100");
        MRD.setText("Rs.400");

        totalamt.setText("Rs.1200");
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
            Intent in = new Intent(ReservedPaymentsActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
