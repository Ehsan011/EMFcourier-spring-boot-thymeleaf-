package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    @Column(length = 50, nullable = false)
    private  String ccCompanyName;

    @Column(length = 45, nullable = false)
    @Email
    @NotBlank
    private  String ccEmail;

    @NotEmpty
    @Column(length = 255, nullable = false)
    private  String ccAddress;

    @Column(length = 15, nullable = false)
    private  String ccContactNumber;

    @NotEmpty
    @Column(length = 75, nullable = false)
    private  String ccPassword;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;

    private String role;

    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CorporateBooking> contacts=new ArrayList<>();

}
