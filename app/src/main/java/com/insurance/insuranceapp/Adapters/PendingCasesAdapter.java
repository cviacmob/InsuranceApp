package com.insurance.insuranceapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.insurance.insuranceapp.Datamodel.PendingInfo;
import com.insurance.insuranceapp.R;

import java.util.List;

/**
 * Created by Balaji on 4/14/2018.
 */

public class PendingCasesAdapter extends ArrayAdapter<PendingInfo> {

    private List<PendingInfo> pendingInfoList;


    private int lastPostion = -1;

    Context mContext;

    public PendingCasesAdapter(List<PendingInfo> objects, Context context) {
        super(context, R.layout.layout_pending, objects);
        pendingInfoList = objects;
        mContext = context;
    }

    public static class ViewHolder {

        public TextView txt_caseid,txt_type;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PendingInfo all = getItem(position);
        View vw = convertView;
        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inf = LayoutInflater.from(getContext());
            vw = inf.inflate(R.layout.layout_pending, parent, false);
            holder = new ViewHolder();
            holder.txt_caseid = (TextView) vw.findViewById(R.id.txt_caseid);
            holder.txt_type = (TextView) vw.findViewById(R.id.tx_casetype);


            vw.setTag(holder);
        } else {
            holder = (ViewHolder) vw.getTag();
        }


        holder.txt_caseid.setText(all.getCaseId());
        holder.txt_type.setText(all.getCaseType());


        return vw;


    }
}

