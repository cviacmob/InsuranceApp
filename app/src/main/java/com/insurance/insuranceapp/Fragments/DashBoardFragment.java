package com.insurance.insuranceapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.insurance.insuranceapp.Datamodel.UserAccountInfo;
import com.insurance.insuranceapp.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.insurance.insuranceapp.Datamodel.UserAccountInfo.getAll;

/**
 * Created by Balaji on 4/11/2018.
 */

public class DashBoardFragment extends Fragment {
        private TextView save,pending,completed;
        private List<UserAccountInfo> userAccountInfoList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragments, container, false);
        setHasOptionsMenu(true);
        save = (TextView)view.findViewById(R.id.save);
        completed = (TextView)view.findViewById(R.id.completed);
        pending = (TextView)view.findViewById(R.id.pending);
        userAccountInfoList = getAll();

        for(UserAccountInfo user:userAccountInfoList) {
            save.setText(user.getSaved());
            completed.setText(user.getSubmitted());
            pending.setText(user.getPending());
        }
        return view;
    }
    public DashBoardFragment(){

    }
}
