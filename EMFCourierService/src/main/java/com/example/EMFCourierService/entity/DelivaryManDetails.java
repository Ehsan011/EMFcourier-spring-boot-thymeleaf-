package com.example.EMFCourierService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class DelivaryManDetails {

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
    private  String heroLocation;

    @Column
    private int heroStatus;

    @Column
    private  String empId;

}
