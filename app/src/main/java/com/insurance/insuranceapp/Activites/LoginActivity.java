package com.insurance.insuranceapp.Activites;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.insurance.insuranceapp.R;
import com.insurance.insuranceapp.Utilities.InsApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class LoginActivity extends AppCompatActivity {
    Button log;
    EditText uname,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        log = findViewById(R.id.log_btn);
        uname = findViewById(R.id.edt_user_name);
        pass = findViewById(R.id.edt_pass);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_name = uname.getText().toString();
                String p_ass = pass.getText().toString();

                if (!isValidEmail(u_name)){
                    uname.setError("Enter Valid Email");
                    return;
                }

                InsApp app = (InsApp) LoginActivity.this.getApplication();

                if(app.isNetworkStatus()){
                    Intent nav = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(nav);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Check Your Internet Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected boolean isValidEmail(String email) {
        String EMAILPATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAILPATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

}