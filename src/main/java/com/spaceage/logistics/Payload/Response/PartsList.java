package com.spaceage.logistics.Payload.Response;

public class PartsList {
    private int bomNo;
    private  String  partNo;
    private String partDescription;
    private long Version;
    private long qtyReq;
    private String catDescription;

    private String reasons;

    public int getBomNo() {
        return bomNo;
    }

    public void setBomNo(int bomNo) {
        this.bomNo = bomNo;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public long getVersion() {
        return Version;
    }

    public void setVersion(long version) {
        Version = version;
    }

    public long getQtyReq() {
        return qtyReq;
    }

    public void setQtyReq(long qtyReq) {
        this.qtyReq = qtyReq;
    }

    public void setQtyReq(int qtyReq) {
        this.qtyReq = qtyReq;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }



    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }
}
