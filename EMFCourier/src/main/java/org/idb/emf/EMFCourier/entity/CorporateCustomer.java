package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporates")
public class CorporateCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int ccId;

    @Column(length = 50, nullable = false)
    private  String ccCompanyName;
    @Column(length = 45, nullable = false)
    private  String ccEmail;
    @Column(length = 255, nullable = false)
    private  String ccAddress;
    @Column(length = 15, nullable = false)
    private  String ccContactNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;



}
