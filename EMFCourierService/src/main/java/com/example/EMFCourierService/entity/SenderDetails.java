package com.example.EMFCourierService.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // create Table in DB
@Table(name = "sender_details")  // define table name in db
public class SenderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String senderName;
    private String senderMobileNo;
    private String email;
    private String PickAddressType;
    private String district;
    private String nearestArea;
    private String senderAddress;
    private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPickAddressType() {
		return PickAddressType;
	}
	public void setPickAddressType(String pickAddressType) {
		PickAddressType = pickAddressType;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
