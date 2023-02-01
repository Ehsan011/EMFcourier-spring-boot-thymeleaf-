package com.example.EMFCourierService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "delivary_man")
public class Delivery_man {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private  String heroName;

    @Column
    private  String heroCell;

    @Column
    private  String heroEmail;

    @Column
    private  String heroPassword;

    @Column
    private  String heroAddress;

    @Column
    private  String heroCity;

    @Column
    private  String empId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroCell() {
        return heroCell;
    }

    public void setHeroCell(String heroCell) {
        this.heroCell = heroCell;
    }

    public String getHeroEmail() {
        return heroEmail;
    }

    public void setHeroEmail(String heroEmail) {
        this.heroEmail = heroEmail;
    }

    public String getHeroPassword() {
        return heroPassword;
    }

    public void setHeroPassword(String heroPassword) {
        this.heroPassword = heroPassword;
    }

    public String getHeroAddress() {
        return heroAddress;
    }

    public void setHeroAddress(String heroAddress) {
        this.heroAddress = heroAddress;
    }

    public String getHeroCity() {
        return heroCity;
    }

    public void setHeroCity(String heroCity) {
        this.heroCity = heroCity;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
