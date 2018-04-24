package com.insurance.insuranceapp.Activites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingCaseListInfo;
import com.insurance.insuranceapp.Datamodel.UserAccountInfo;
import com.insurance.insuranceapp.R;
import com.insurance.insuranceapp.RestAPI.InsuranceAPI;
import com.insurance.insuranceapp.RestAPI.PendingCasesInfo;
import com.insurance.insuranceapp.Utilities.InsApp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Call;
import retrofit.GsonConverterFactory;

import static com.insurance.insuranceapp.Datamodel.UserAccountInfo.getAll;

public class CompletedCaseActivity extends AppCompatActivity {
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingCaseListInfo> pendingInfoList;
    private ListView listView;
    ProgressDialog progressDialog;
    InsApp api;
    InsuranceAPI insuranceAPI;
    private List<UserAccountInfo> userAccountInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_case);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Completed Cases");
        listView = findViewById(R.id.lab_list);
        userAccountInfoList  = getAll();
        getLogin();
    }

    private void getList(List<PendingCaseListInfo> pendingCasesActivityList) {

        pendingcaseAdapter = new PendingCasesAdapter(pendingCasesActivityList,this.getApplication());
        listView.setDivider(null);
        listView.setAdapter(pendingcaseAdapter);

    }
    private void getLogin() {

        String consultantid = "";
        progressDialog = new ProgressDialog(CompletedCaseActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        okHttpClient.setConnectTimeout(120000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(120000, TimeUnit.MILLISECONDS);
        retrofit.Retrofit retrofit = new retrofit.Retrofit.Builder()
                .baseUrl("http://vevelanbus.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        insuranceAPI = retrofit.create(InsuranceAPI.class);
        PendingCasesInfo reg =new PendingCasesInfo();
        for(UserAccountInfo user:userAccountInfoList) {
            reg.setConsultant_id(user.getConsultant_id());
            consultantid=user.getConsultant_id();
        }
        reg.setStatus("Submitted");


        Call<List<PendingCaseListInfo>> call = insuranceAPI.getpendinglist(consultantid , "submitted");
        call.enqueue(new retrofit.Callback<List<PendingCaseListInfo>>() {
            @Override
            public void onResponse(retrofit.Response<List<PendingCaseListInfo>> response, retrofit.Retrofit retrofit) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                pendingInfoList =  response.body();
                // profileInfoList = response.body();

                if (response.code() == 200) {
                    if(pendingInfoList!=null){
                        getList(pendingInfoList);
                    }

                }

            }


            @Override
            public void onFailure(Throwable t) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                Toast.makeText(CompletedCaseActivity.this, "Network Issue" + t, Toast.LENGTH_SHORT).show();

            }
        });


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
            Intent in = new Intent(CompletedCaseActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
