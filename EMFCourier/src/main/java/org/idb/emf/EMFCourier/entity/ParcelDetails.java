package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // create Table in DB
@Data // getter and Setter
@NoArgsConstructor // Default Constructor
@AllArgsConstructor // perameterised Constructor
@Table(name = "parcel_details")
public class ParcelDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String selectProductType;
    private double packageWeight ;
    private String whatDoesThisParcelContain;
    private String  numberOfItem;



}
