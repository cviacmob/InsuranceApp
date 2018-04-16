package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final PendingInfo pendingInfo= (PendingInfo) parent.getAdapter().getItem(position);
                String Block_Name = pendingInfo.getBlock_name();
                if(Block_Name!=null) {
                    if (Block_Name.equalsIgnoreCase("Hospital Block")) {
                        Intent in = new Intent(PendingCasesActivity.this, HospitalBlockActivity.class);
                        startActivity(in);
                    }
                }

                //audio to be added;




            }
        });

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
            Intent in = new Intent(PendingCasesActivity.this,MainActivity.class);
            startActivity(in);
            return true;
        }
        onBackPressed();
        return true;
    }
}
