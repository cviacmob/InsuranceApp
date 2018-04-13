package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.util.ArrayList;
import java.util.List;

public class PendingCasesActivity extends AppCompatActivity {
    private ListView listView;
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingInfo> pendingInfoList;
    private PendingInfo pendingInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Pending Cases");
        listView = (ListView)findViewById(R.id.lab_list);
        pendingInfoList =  getList();
        pendingcaseAdapter = new PendingCasesAdapter(pendingInfoList,this.getApplication());
        listView.setDivider(null);
        listView.setAdapter(pendingcaseAdapter);


    }


    private List<PendingInfo> getList(){

        pendingInfoList = new ArrayList<>();
        pendingInfoList.add(new PendingInfo("1","pending"));
        pendingInfoList.add(new PendingInfo("2","save"));
        pendingInfoList.add(new PendingInfo("3","pending"));
        pendingInfoList.add(new PendingInfo("4","pending"));
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
            Intent in = new Intent(PendingCasesActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
