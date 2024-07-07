package com.example.SnapAndClean;

import java.io.Serializable;

public class Productmodel implements Serializable {
    //In Android we can not pass object to the activities
    //To do that object must implement Serializable or parcelable interface

    String accptedBy;
    String address;
    String area;
    String date;
    String delete;
    String description;
    String docId;
    String name;
    String pin_Code;
    String sendedBy;
    String time;
    String type;
    String uri;

    public Productmodel() {
    }

    public Productmodel(String accptedBy, String address, String area, String date, String delete, String description, String docId, String name, String pin_Code, String sendedBy, String time, String type, String uri) {
        this.accptedBy = accptedBy;
        this.address = address;
        this.area = area;
        this.date = date;
        this.delete = delete;
        this.description = description;
        this.docId = docId;
        this.name = name;
        this.pin_Code = pin_Code;
        this.sendedBy = sendedBy;
        this.time = time;
        this.type = type;
        this.uri = uri;
    }

    public String getAccptedBy() {
        return accptedBy;
    }

    public void setAccptedBy(String accptedBy) {
        this.accptedBy = accptedBy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin_Code() {
        return pin_Code;
    }

    public void setPin_Code(String pin_Code) {
        this.pin_Code = pin_Code;
    }

    public String getSendedBy() {
        return sendedBy;
    }

    public void setSendedBy(String sendedBy) {
        this.sendedBy = sendedBy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}