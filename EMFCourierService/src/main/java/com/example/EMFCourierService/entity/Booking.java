package com.example.EMFCourierService.entity;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int trakingNumber;
    private int delivaryManId;
    private int officeExecutiveId;
    private String parcelStatus;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrakingNumber() {
        return trakingNumber;
    }

    public void setTrakingNumber(int trakingNumber) {
        this.trakingNumber = trakingNumber;
    }

    public int getDelivaryManId() {
        return delivaryManId;
    }

    public void setDelivaryManId(int delivaryManId) {
        this.delivaryManId = delivaryManId;
    }

    public int getOfficeExecutiveId() {
        return officeExecutiveId;
    }

    public void setOfficeExecutiveId(int officeExecutiveId) {
        this.officeExecutiveId = officeExecutiveId;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }
}
