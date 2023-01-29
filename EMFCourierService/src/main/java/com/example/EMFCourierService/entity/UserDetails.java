package com.example.EMFCourierService.entity;

import javax.persistence.*;


@Entity // create Table in DB
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String senderName;
    private String senderMobileNo;
    private String district;
    private String nearestArea;
    private String senderAddress;
    private int postalCode;
    private String recipientName;
    private String recipientMobileNo;
    private String recipientAddress;
    private String sendPickNotifaction;
    private String selectProductType;
    private String packageWeight ;
    private String  numberOfItem;
    private String payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMobileNo() {
        return senderMobileNo;
    }

    public void setSenderMobileNo(String senderMobileNo) {
        this.senderMobileNo = senderMobileNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNearestArea() {
        return nearestArea;
    }

    public void setNearestArea(String nearestArea) {
        this.nearestArea = nearestArea;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientMobileNo() {
        return recipientMobileNo;
    }

    public void setRecipientMobileNo(String recipientMobileNo) {
        this.recipientMobileNo = recipientMobileNo;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getSendPickNotifaction() {
        return sendPickNotifaction;
    }

    public void setSendPickNotifaction(String sendPickNotifaction) {
        this.sendPickNotifaction = sendPickNotifaction;
    }

    public String getSelectProductType() {
        return selectProductType;
    }

    public void setSelectProductType(String selectProductType) {
        this.selectProductType = selectProductType;
    }

    public String getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
    }

    public String getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(String numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
