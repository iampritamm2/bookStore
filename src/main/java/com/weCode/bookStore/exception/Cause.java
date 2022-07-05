package com.weCode.bookStore.exception;

import java.util.Map;

public class Cause {


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public Map<String, String> getValidation() {
        return validation;
    }

    public void setValidation(Map<String, String> validation) {
        this.validation = validation;
    }

    public Cause(String details, String locationCode, String fieldId, Map<String, String> validation) {
        this.details = details;
        this.locationCode = locationCode;
        this.fieldId = fieldId;
        this.validation = validation;
    }

    private String details;
    private String locationCode;
    private String fieldId;
    private Map<String,String > validation;
}
