package com.example.EMFCourierService.entity;


import javax.persistence.*;


import java.util.Date;


@Entity
@Table(name = "corporates")
public class CorporateCustomer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccId;


    @Column(length = 50, nullable = false)
    private String ccCompanyName;

    @Column(length = 45, nullable = false)

    private String ccEmail;


    @Column(length = 255, nullable = false)
    private String ccAddress;

    @Column(length = 15, nullable = false)
    private String ccContactNumber;


    @Column(length = 75, nullable = false)
    private String ccPassword;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String role;

    private boolean isEnabled;

    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    public String getCcCompanyName() {
        return ccCompanyName;
    }

    public void setCcCompanyName(String ccCompanyName) {
        this.ccCompanyName = ccCompanyName;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getCcContactNumber() {
        return ccContactNumber;
    }

    public void setCcContactNumber(String ccContactNumber) {
        this.ccContactNumber = ccContactNumber;
    }

    public String getCcPassword() {
        return ccPassword;
    }

    public void setCcPassword(String ccPassword) {
        this.ccPassword = ccPassword;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
