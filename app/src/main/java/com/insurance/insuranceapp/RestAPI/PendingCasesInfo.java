package com.insurance.insuranceapp.RestAPI;

/**
 * Created by Balaji on 4/23/2018.
 */

public class PendingCasesInfo {
    private String consultant_id;
    private String status;


    public String getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(String consultant_id) {
        this.consultant_id = consultant_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
