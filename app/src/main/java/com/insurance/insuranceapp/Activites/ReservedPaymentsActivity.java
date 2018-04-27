package com.insurance.insuranceapp.Activites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.insurance.insuranceapp.Datamodel.GetPaymentsInfo;
import com.insurance.insuranceapp.Datamodel.PendingCaseListInfo;
import com.insurance.insuranceapp.Datamodel.UserAccountInfo;
import com.insurance.insuranceapp.R;
import com.insurance.insuranceapp.RestAPI.InsuranceAPI;
import com.insurance.insuranceapp.Utilities.AlertDialogNoData;
import com.insurance.insuranceapp.Utilities.InsApp;
import com.insurance.insuranceapp.Utilities.Prefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Call;
import retrofit.GsonConverterFactory;

import static com.insurance.insuranceapp.Datamodel.UserAccountInfo.getAll;

public class ReservedPaymentsActivity extends AppCompatActivity {
    private String mode;
    private TableLayout tableLayout;
    private TableRow row1,row2,row3,row4,row5,row6,row7,row9;
    private TextView claim_number,patientname,blockname,convanceypay,TA,MRD,incentive,totalamt;
    ProgressDialog progressDialog;
    InsApp api;
    InsuranceAPI insuranceAPI;
    private List<UserAccountInfo> userAccountInfoList;
    private String domainurl;
    private List<GetPaymentsInfo> getPaymentsInfo;
    private PendingCaseListInfo pendingCaseListInfo;
    private String case_Assignment_id= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_payments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         mode =  getIntent().getStringExtra("paymentscase");
        userAccountInfoList  = getAll();
        domainurl = Prefs.getString("domainurl", "");
        pendingCaseListInfo = (PendingCaseListInfo) getIntent().getSerializableExtra("object");
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
        convanceypay =(TextView)row4.getChildAt(1);
        incentive =(TextView)row5.getChildAt(1);
        TA =(TextView)row6.getChildAt(1);
        MRD =(TextView)row7.getChildAt(1);
        totalamt =(TextView)row9.getChildAt(1);

       if(mode.equalsIgnoreCase("submitted")){
           setTitle("Confirmed Payments");
           getpayments();
       }else if(mode.equalsIgnoreCase("Reserved")){
           setTitle("Reserved Payments");
           getpayments();


       }



    }


    private void reservedtext_values(){
        if(getPaymentsInfo!=null) {
            for(GetPaymentsInfo pay:getPaymentsInfo) {
                claim_number.setText(pay.getClaim_no());
                patientname.setText(pay.getPatient_name());
                blockname.setText(pay.getCase_type());
                try {
                    int consultant_fee = Integer.parseInt(pay.getConsultant_fee()!=null?pay.getConsultant_fee():"0");
                convanceypay.setText(""+consultant_fee);
                int insentive = Integer.parseInt(pay.getConsult_insentivies()!=null?pay.getConsult_insentivies():"0");
                incentive.setText(""+insentive);
                int ta = Integer.parseInt(pay.getPay_conveyance()!=null?pay.getPay_conveyance():"0");
                TA.setText(""+ta);
                int mrd = Integer.parseInt(pay.getMrd_amount()!=null?pay.getMrd_amount():"0");
                MRD.setText(""+mrd);
                int total = consultant_fee+insentive+ta+mrd;
                totalamt.setText("Rs. " + total);

                }
                catch (Exception e) {
                    Toast.makeText(ReservedPaymentsActivity.this, "reservedtext_values", Toast.LENGTH_LONG).show();
                }
            }
        }
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


    private void getpayments() {

        String consultantid = "";
        progressDialog = new ProgressDialog(ReservedPaymentsActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        okHttpClient.setConnectTimeout(120000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(120000, TimeUnit.MILLISECONDS);

        retrofit.Retrofit retrofit = new retrofit.Retrofit.Builder()
                .baseUrl(domainurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        insuranceAPI = retrofit.create(InsuranceAPI.class);

        for(UserAccountInfo user:userAccountInfoList) {
            consultantid=user.getConsultant_id();
        }

        case_Assignment_id = pendingCaseListInfo.getCase_assignment_id();
        Call<List<GetPaymentsInfo>> call = insuranceAPI.getgetpayments(consultantid , mode,case_Assignment_id);
        call.enqueue(new retrofit.Callback<List<GetPaymentsInfo>>() {
            @Override
            public void onResponse(retrofit.Response<List<GetPaymentsInfo>> response, retrofit.Retrofit retrofit) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
               getPaymentsInfo = response.body();
                reservedtext_values();

               /* if (response.code() == 200) {
                    if(pendingInfoList!=null){
                        getList(pendingInfoList);
                    }else if(pendingInfoList==null){
                        AlertDialogNoData.alertdialog(ReservedPaymentsActivity.this);
                    }

                }*/

            }


            @Override
            public void onFailure(Throwable t) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                Toast.makeText(ReservedPaymentsActivity.this, "Network Issue" + t, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
