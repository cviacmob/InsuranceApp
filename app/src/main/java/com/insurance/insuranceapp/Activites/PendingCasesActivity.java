package com.insurance.insuranceapp.Activites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.insurance.insuranceapp.Adapters.PendingCasesAdapter;
import com.insurance.insuranceapp.Datamodel.PendingCaseListInfo;
import com.insurance.insuranceapp.RestAPI.PendingCasesInfo;
import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.Datamodel.UserAccountInfo;
import com.insurance.insuranceapp.R;
import com.insurance.insuranceapp.RestAPI.InsuranceAPI;
import com.insurance.insuranceapp.Utilities.InsApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.insurance.insuranceapp.Datamodel.UserAccountInfo.getAll;

public class PendingCasesActivity extends AppCompatActivity {
    private ListView listView;
    private Button btn;
    private PendingCasesAdapter pendingcaseAdapter;
    private List<PendingCaseListInfo> pendingInfoList;
    private PendingInfo pendingInfo;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder ;
    Random random ;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer ;
    ProgressDialog progressDialog;
    InsApp api;
    InsuranceAPI insuranceAPI;
    private List<UserAccountInfo> userAccountInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_cases);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Pending Cases");
        userAccountInfoList  = getAll();
        listView = findViewById(R.id.lab_list);
        btn = findViewById(R.id.btn_media);
        getLogin();
        pendingcaseAdapter = new PendingCasesAdapter(pendingInfoList,this.getApplication());
        listView.setDivider(null);
        listView.setAdapter(pendingcaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final PendingInfo pendingInfo= (PendingInfo) parent.getAdapter().getItem(position);
                String Block_Name = pendingInfo.getCase_type();
                if(Block_Name!=null) {
                    if (Block_Name.equalsIgnoreCase("Hospital Block")) {
                        Intent in = new Intent(PendingCasesActivity.this, HospitalBlockActivity.class);
                        startActivity(in);
                    }else if(Block_Name.equalsIgnoreCase("Patient Part")){
                        Intent in = new Intent(PendingCasesActivity.this, PatientBlockActivity.class);
                        startActivity(in);
                    } else if(Block_Name.equalsIgnoreCase("SME")){
                        Intent in = new Intent(PendingCasesActivity.this, SMEActivity.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Death Claim")){
                        Intent in = new Intent(PendingCasesActivity.this, DeathCliamActivity.class);
                        startActivity(in);
                    }else if(Block_Name.equalsIgnoreCase("Disability")){
                        Intent in = new Intent(PendingCasesActivity.this, DisabilityActivity.class);
                        startActivity(in);
                    }else if(Block_Name.equalsIgnoreCase("PersonalAccident")){
                        Intent in = new Intent(PendingCasesActivity.this, PersonalAccidentActivity.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Bill Verification Hospital")){
                        Intent in = new Intent(PendingCasesActivity.this, BillVerificationHospital.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Bill Verification Pharmacy")){
                        Intent in = new Intent(PendingCasesActivity.this, BillVerificationPharmacy.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Documents Verification")){
                        Intent in = new Intent(PendingCasesActivity.this, DocumentsVerification.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Cashless")){
                        Intent in = new Intent(PendingCasesActivity.this, Cashless.class);
                        startActivity(in);
                    }
                    else if(Block_Name.equalsIgnoreCase("Intimation Case")){
                        Intent in = new Intent(PendingCasesActivity.this, IntimationCase.class);
                        startActivity(in);
                    }else if(Block_Name.equalsIgnoreCase("Others")){
                        Intent in = new Intent(PendingCasesActivity.this, DynamicActivity.class);
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

   /* private List<PendingInfo> getList(){

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


*//*

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

        PendingInfo pendingInfo2 = new PendingInfo();
        pendingInfo2.setClaim_no("5461236");
        pendingInfo2.setPatientName("Varun");
        pendingInfo2.setBlock_name("SME");
        pendingInfo2.setPolicy_no("54322579");
        pendingInfo2.setInsurance_company("LIC");
        pendingInfo2.setCase_name("SME");
        pendingInfo2.setAssigned_to("Vijila");
        pendingInfo2.setCase_assigned_on("06-04-2018");
        pendingInfo2.setStatus("pending");
        pendingInfoList.add(pendingInfo2);


        PendingInfo pendingInfo3 = new PendingInfo();
        pendingInfo3.setClaim_no("5461236");
        pendingInfo3.setPatientName("Varun");
        pendingInfo3.setBlock_name("Death Claim");
        pendingInfo3.setPolicy_no("54322579");
        pendingInfo3.setInsurance_company("LIC");
        pendingInfo3.setCase_name("Death Claim");
        pendingInfo3.setAssigned_to("Vijila");
        pendingInfo3.setCase_assigned_on("06-04-2018");
        pendingInfo3.setStatus("pending");
        pendingInfoList.add(pendingInfo3);

        PendingInfo pendingInfo4 = new PendingInfo();
        pendingInfo4.setClaim_no("5461236");
        pendingInfo4.setPatientName("Varun");
        pendingInfo4.setBlock_name("Disability");
        pendingInfo4.setPolicy_no("54322579");
        pendingInfo4.setInsurance_company("LIC");
        pendingInfo4.setCase_name("Disability");
        pendingInfo4.setAssigned_to("Vijila");
        pendingInfo4.setCase_assigned_on("06-04-2018");
        pendingInfo4.setStatus("pending");
        pendingInfoList.add(pendingInfo4);

        PendingInfo pendingInfo5 = new PendingInfo();
        pendingInfo5.setClaim_no("5461236");
        pendingInfo5.setPatientName("Varun");
        pendingInfo5.setBlock_name("PersonalAccident");
        pendingInfo5.setPolicy_no("54322579");
        pendingInfo5.setInsurance_company("LIC");
        pendingInfo5.setCase_name("PersonalAccident");
        pendingInfo5.setAssigned_to("Vijila");
        pendingInfo5.setCase_assigned_on("06-04-2018");
        pendingInfo5.setStatus("pending");
        pendingInfoList.add(pendingInfo5);

        PendingInfo pendingInfo6 = new PendingInfo();
        pendingInfo6.setClaim_no("5461236");
        pendingInfo6.setPatientName("Varun");
        pendingInfo6.setBlock_name("Bill Verification Hospital");
        pendingInfo6.setPolicy_no("54322579");
        pendingInfo6.setInsurance_company("LIC");
        pendingInfo6.setCase_name("Bill Verification Hospital");
        pendingInfo6.setAssigned_to("Vijila");
        pendingInfo6.setCase_assigned_on("06-04-2018");
        pendingInfo6.setStatus("pending");
        pendingInfoList.add(pendingInfo6);

        PendingInfo pendingInfo7 = new PendingInfo();
        pendingInfo7.setClaim_no("5461236");
        pendingInfo7.setPatientName("Varun");
        pendingInfo7.setBlock_name("Bill Verification Pharmacy");
        pendingInfo7.setPolicy_no("54322579");
        pendingInfo7.setInsurance_company("LIC");
        pendingInfo7.setCase_name("Bill Verification Pharmacy");
        pendingInfo7.setAssigned_to("Vijila");
        pendingInfo7.setCase_assigned_on("06-04-2018");
        pendingInfo7.setStatus("pending");
        pendingInfoList.add(pendingInfo7);

        PendingInfo pendingInfo8 = new PendingInfo();
        pendingInfo8.setClaim_no("5461236");
        pendingInfo8.setPatientName("Varun");
        pendingInfo8.setBlock_name("Documents Verification");
        pendingInfo8.setPolicy_no("54322579");
        pendingInfo8.setInsurance_company("LIC");
        pendingInfo8.setCase_name("Documents Verification");
        pendingInfo8.setAssigned_to("Vijila");
        pendingInfo8.setCase_assigned_on("06-04-2018");
        pendingInfo8.setStatus("pending");
        pendingInfoList.add(pendingInfo8);


        PendingInfo pendingInfo9 = new PendingInfo();
        pendingInfo9.setClaim_no("5461236");
        pendingInfo9.setPatientName("Varun");
        pendingInfo9.setBlock_name("Cashless");
        pendingInfo9.setPolicy_no("54322579");
        pendingInfo9.setInsurance_company("LIC");
        pendingInfo9.setCase_name("Cashless");
        pendingInfo9.setAssigned_to("Vijila");
        pendingInfo9.setCase_assigned_on("06-04-2018");
        pendingInfo9.setStatus("pending");
        pendingInfoList.add(pendingInfo9);

        PendingInfo pendingInfo10 = new PendingInfo();
        pendingInfo10.setClaim_no("5461236");
        pendingInfo10.setPatientName("Varun");
        pendingInfo10.setBlock_name("Intimation Case");
        pendingInfo10.setPolicy_no("54322579");
        pendingInfo10.setInsurance_company("LIC");
        pendingInfo10.setCase_name("Intimation Case");
        pendingInfo10.setAssigned_to("Vijila");
        pendingInfo10.setCase_assigned_on("06-04-2018");
        pendingInfo10.setStatus("pending");
        pendingInfoList.add(pendingInfo10);

        PendingInfo pendingInfo11 = new PendingInfo();
        pendingInfo11.setClaim_no("5461236");
        pendingInfo11.setPatientName("Varun");
        pendingInfo11.setBlock_name("Others");
        pendingInfo11.setPolicy_no("54322579");
        pendingInfo11.setInsurance_company("LIC");
        pendingInfo11.setCase_name("Intimation Case");
        pendingInfo11.setAssigned_to("Others");
        pendingInfo11.setCase_assigned_on("06-04-2018");
        pendingInfo11.setStatus("pending");
        pendingInfoList.add(pendingInfo11);
*//*

        return pendingInfoList;
    }*/
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


    private void getLogin() {

String consultantid = "";
        progressDialog = new ProgressDialog(PendingCasesActivity.this, R.style.AppTheme_Dark_Dialog);
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
        reg.setStatus("pending");


      Call<List<PendingCaseListInfo>> call = insuranceAPI.getpendinglist(consultantid , "pending");
        call.enqueue(new retrofit.Callback<List<PendingCaseListInfo>>() {
            @Override
            public void onResponse(Response<List<PendingCaseListInfo>> response, Retrofit retrofit) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                List<PendingCaseListInfo> res =  response.body();
                // profileInfoList = response.body();

                if (response.code() == 200) {






                }

            }


            @Override
            public void onFailure(Throwable t) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }

                Toast.makeText(PendingCasesActivity.this, "Network Issue" + t, Toast.LENGTH_SHORT).show();

            }
        });


    }
}