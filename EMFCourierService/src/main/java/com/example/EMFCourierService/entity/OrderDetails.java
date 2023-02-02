package com.example.EMFCourierService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int order_id;
    @Column
    private String recipientName;
    @Column
    private String recipientMobileNo;
    @Column
    private String recipientAddress;
    @Column
    private String userLocation;
    @Column
    private String selectProductType;
    @Column
    private String packageWeight ;
    @Column
    private String  numberOfItem;
    @Column
    private String payment;
    @Column
    int orderActivityStatus = 1;

}
