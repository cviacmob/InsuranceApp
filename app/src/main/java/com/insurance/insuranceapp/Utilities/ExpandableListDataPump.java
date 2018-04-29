package com.insurance.insuranceapp.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Balaji on 4/11/2018.
 */

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> dashboard = new ArrayList<String>();

        List<String> payments = new ArrayList<String>();
        payments.add("Reserved Payments");
        payments.add("Confirmed Payments");

        List<String> cases = new ArrayList<String>();
        cases.add("Pending Cases");
        cases.add("Submitted Cases");
        cases.add("Save Cases");

        Collections.sort(payments);
        Collections.sort(cases);

        expandableListDetail.put("Dashboard", cases);
        expandableListDetail.put("Payments", payments);
        expandableListDetail.put("Cases", dashboard);

        return expandableListDetail;
    }
}