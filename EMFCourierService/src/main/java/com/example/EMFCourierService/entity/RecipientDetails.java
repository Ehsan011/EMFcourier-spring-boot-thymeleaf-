package com.example.EMFCourierService.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // create Table in DB
@Table(name = "recipient_details")
public class RecipientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int senderId;
    private String recipientName;
    private String recipientMobileNo;
    private String district;
    private String nearestArea;
    private String recipientAddress;
    private String instruction;
    private String sendPickNotifaction;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
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
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getSendPickNotifaction() {
		return sendPickNotifaction;
	}
	public void setSendPickNotifaction(String sendPickNotifaction) {
		this.sendPickNotifaction = sendPickNotifaction;
	}
    
    
}