package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PendingCasesActivity extends AppCompatActivity {
    private ListView listView;
    private Button btn;
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingInfo> pendingInfoList;
    private PendingInfo pendingInfo;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder ;
    Random random ;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Pending Cases");
        listView = findViewById(R.id.lab_list);
        btn = findViewById(R.id.btn_media);
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
                    }else if(Block_Name.equalsIgnoreCase("Patient Part")){
                        Intent in = new Intent(PendingCasesActivity.this, PatientBlockActivity.class);
                        startActivity(in);
                    }
                   /* random = new Random();
                    if(checkPermission()) {
                        AudioSavePathInDevice = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + CreateRandomAudioFileName(5) + "AudioRecording.3gp";
                        MediaRecorderReady();
                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        Toast.makeText(PendingCasesActivity.this, "Recording started", Toast.LENGTH_LONG).show();
                    }
                    else {
                        requestPermission();
                    }*/
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                Toast.makeText(PendingCasesActivity.this,"Recording Works",Toast.LENGTH_SHORT).show();
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
        pendingInfo1.setBlock_name("Patient Part");
        pendingInfo1.setPolicy_no("54322579");
        pendingInfo1.setInsurance_company("LIC");
        pendingInfo1.setCase_name("Patient Part");
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
    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
    public String CreateRandomAudioFileName(int string){
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.charAt(random.nextInt(RandomAudioFileName.length())));
            i++ ;
        }
        return stringBuilder.toString();
    }
    public void MediaRecorderReady(){
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(AudioSavePathInDevice);
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(PendingCasesActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }
}