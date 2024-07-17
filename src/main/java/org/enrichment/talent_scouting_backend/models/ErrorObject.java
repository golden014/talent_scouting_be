package org.enrichment.talent_scouting_backend.models;

public class ErrorObject {

    private String errorMsg;

    public ErrorObject(String msg) {
        this.errorMsg = msg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
