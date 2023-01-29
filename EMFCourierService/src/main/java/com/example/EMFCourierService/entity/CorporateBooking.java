package com.example.EMFCourierService.entity;



import javax.persistence.*;


@Entity
@Table
public class CorporateBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int cbId;
    @Column(length = 60, nullable = false)
    private String parcelName;
    @Column(length = 10, nullable = false)
    private String parcelQuantity;
    @Column(length = 10, nullable = false)
    private String parcelWeight;

    @Column(name = "cb_Traking_no", unique = true, updatable = false)
    private String parcelTrakingNumber;

    public int getCbId() {
        return cbId;
    }

    public void setCbId(int cbId) {
        this.cbId = cbId;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public String getParcelQuantity() {
        return parcelQuantity;
    }

    public void setParcelQuantity(String parcelQuantity) {
        this.parcelQuantity = parcelQuantity;
    }

    public String getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(String parcelWeight) {
        this.parcelWeight = parcelWeight;
    }

    public String getParcelTrakingNumber() {
        return parcelTrakingNumber;
    }

    public void setParcelTrakingNumber(String parcelTrakingNumber) {
        this.parcelTrakingNumber = parcelTrakingNumber;
    }
}
