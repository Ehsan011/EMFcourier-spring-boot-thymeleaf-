package com.example.EMFCourierService.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity // create Table in DB
@Table(name = "parcel_details")
public class ParcelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int senderId;
    private int recipientId;
    private String selectProductType;
    private String packageWeight ;
    private String whatDoesThisParcelContain;
    private String  numberOfItem;
    private String payment;
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
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
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
	public String getWhatDoesThisParcelContain() {
		return whatDoesThisParcelContain;
	}
	public void setWhatDoesThisParcelContain(String whatDoesThisParcelContain) {
		this.whatDoesThisParcelContain = whatDoesThisParcelContain;
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
