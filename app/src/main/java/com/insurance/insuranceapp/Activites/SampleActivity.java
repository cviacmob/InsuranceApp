package com.insurance.insuranceapp.Activites;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.insurance.insuranceapp.Fragments.HospitalPartFragment;
import com.insurance.insuranceapp.Fragments.HospitalPartSecondFragment;
import com.insurance.insuranceapp.Fragments.HospitalPartThirdFragment;
import com.insurance.insuranceapp.R;



public class SampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return new HospitalPartFragment();
                case 1: return new HospitalPartSecondFragment();
                case 2: return new HospitalPartThirdFragment();
                default: return  new HospitalPartFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
