package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Column(length = 75, nullable = false)
    private  String ccPassword;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String role;

    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CorporateBooking> contacts=new ArrayList<>();

}
