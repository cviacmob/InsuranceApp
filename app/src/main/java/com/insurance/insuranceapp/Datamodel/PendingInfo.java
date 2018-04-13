package com.insurance.insuranceapp.Datamodel;

/**
 * Created by Balaji on 4/14/2018.
 */

public class PendingInfo {
    private String caseId;
    private String caseType;

    public PendingInfo(String caseId, String caseType) {
        this.caseId = caseId;
        this.caseType = caseType;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}
