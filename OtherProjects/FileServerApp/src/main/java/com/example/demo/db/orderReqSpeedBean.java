package com.example.demo.db;

public class orderReqSpeedBean {
    private String actiondate;

    private String instrumentid;

    private Double orderVolume;

    private Double secVolume;

    private Double secMaxVolume;

    private String orderRef;

    private Double secMinVolume;

    public String getActiondate() {
        return actiondate;
    }

    public void setActiondate(String actiondate) {
        this.actiondate = actiondate == null ? null : actiondate.trim();
    }

    public String getInstrumentid() {
        return instrumentid;
    }

    public void setInstrumentid(String instrumentid) {
        this.instrumentid = instrumentid == null ? null : instrumentid.trim();
    }

    public Double getOrderVolume() {
        return orderVolume;
    }

    public void setOrderVolume(Double orderVolume) {
        this.orderVolume = orderVolume;
    }

    public Double getSecVolume() {
        return secVolume;
    }

    public void setSecVolume(Double secVolume) {
        this.secVolume = secVolume;
    }

    public Double getSecMaxVolume() {
        return secMaxVolume;
    }

    public void setSecMaxVolume(Double secMaxVolume) {
        this.secMaxVolume = secMaxVolume;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef == null ? null : orderRef.trim();
    }

    public Double getSecMinVolume() {
        return secMinVolume;
    }

    public void setSecMinVolume(Double secMinVolume) {
        this.secMinVolume = secMinVolume;
    }
}