package com.insurance.insuranceapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.insurance.insuranceapp.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Balaji on 4/11/2018.
 */

public class DashBoardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragments, container, false);
        setHasOptionsMenu(true);

        return view;
    }
    public DashBoardFragment(){

    }
}
