package com.insurance.insuranceapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.insurance.insuranceapp.Datamodel.PendingCaseListInfo;
import com.insurance.insuranceapp.R;

import java.util.List;

/**
 * Created by Balaji on 4/14/2018.
 */

public class PendingCasesAdapter extends ArrayAdapter<PendingCaseListInfo> {

    private List<PendingCaseListInfo> pendingInfoList;


    private int lastPostion = -1;

    Context mContext;

    public PendingCasesAdapter(List<PendingCaseListInfo> objects, Context context) {
        super(context, R.layout.layout_pending, objects);
        pendingInfoList = objects;
        mContext = context;
    }

    public static class ViewHolder {
        public TableLayout tableLayout;
        public TableRow row1,row2,row3,row4,row5,row6,row7,row8,row9,row10;
        public TextView claim_number,patientname,blockname,policy_no,insurance_compy,case_id,Assigned_to,case_assigned_on,status,case_type_id;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PendingCaseListInfo all = getItem(position);
        View vw = convertView;
        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inf = LayoutInflater.from(getContext());
            vw = inf.inflate(R.layout.layout_pending, parent, false);
            holder = new ViewHolder();
            holder.tableLayout = (TableLayout)vw.findViewById(R.id.tableLayout);
            holder.row1 = (TableRow) holder.tableLayout.getChildAt(0);
            holder.row2 = (TableRow) holder.tableLayout.getChildAt(1);
            holder.row3 = (TableRow) holder.tableLayout.getChildAt(2);
            holder.row4 = (TableRow) holder.tableLayout.getChildAt(3);
            holder.row5 = (TableRow) holder.tableLayout.getChildAt(4);
            holder.row6 = (TableRow) holder.tableLayout.getChildAt(5);
            holder.row7 = (TableRow) holder.tableLayout.getChildAt(6);
            holder.row8 = (TableRow) holder.tableLayout.getChildAt(7);
            holder.row9 = (TableRow) holder.tableLayout.getChildAt(8);
            holder.row10 = (TableRow) holder.tableLayout.getChildAt(9);



            holder.claim_number =(TextView)holder.row1.getChildAt(1);
            holder.patientname =(TextView)holder.row2.getChildAt(1);
            holder.blockname =(TextView)holder.row3.getChildAt(1);
            holder.case_type_id =(TextView)holder.row4.getChildAt(1);
            holder.policy_no =(TextView)holder.row5.getChildAt(1);
            holder.insurance_compy =(TextView)holder.row6.getChildAt(1);
            holder.case_id =(TextView)holder.row7.getChildAt(1);
            holder.Assigned_to =(TextView)holder.row8.getChildAt(1);
            holder.case_assigned_on =(TextView)holder.row9.getChildAt(1);
            holder.status =(TextView)holder.row10.getChildAt(1);

            vw.setTag(holder);
        } else {
            holder = (ViewHolder) vw.getTag();
        }


        holder.claim_number.setText(all.getClaim_no());
        holder.patientname.setText(all.getPatient_name());
        holder.blockname.setText(all.getCase_type());
        holder.case_type_id.setText(all.getCase_type_id());
        holder.policy_no.setText(all.getPolicy_number());
        holder.insurance_compy.setText(all.getCompany_name());
        holder.case_id.setText(all.getCase_id());
        holder.Assigned_to.setText(all.getCase_assigned_on());
        holder.case_assigned_on.setText(all.getCase_assigned_on());
        holder.status.setText(all.getAssign_status());



        return vw;


    }
}

