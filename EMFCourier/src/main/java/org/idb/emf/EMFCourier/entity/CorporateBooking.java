package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
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

    @Column(name = "cb_Traking_no")
    private String parcelTrakingNumber;

    public CorporateBooking() {
        this.parcelTrakingNumber = UUID.randomUUID().toString();
    }
}
