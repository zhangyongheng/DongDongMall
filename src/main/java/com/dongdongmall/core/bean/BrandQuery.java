package com.dongdongmall.core.bean;

public class BrandQuery {
    private int startRecords;
    private int pageSize;
    private int pageNo;
    private String name;
    private int isVisit;


    public BrandQuery() {
        setPageSize(3);
        setIsVisit(1);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRecords() {
        return (pageNo - 1) * pageSize;
    }

    public void setStartRecords(int startRecords) {
        this.startRecords = startRecords;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(int isVisit) {
        this.isVisit = isVisit;
    }
}
