package com.insurance.insuranceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insurance.insuranceapp.R;

/**
 * Created by Balaji on 4/18/2018.
 */

public class HospitalPartSecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hospitalpartsecond, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);

        return v;
    }


}