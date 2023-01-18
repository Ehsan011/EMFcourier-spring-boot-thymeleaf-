package org.idb.emf.EMFCourier.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employeeData")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String empFirstName;
    @Column(length = 50, nullable = false)
    private String empLastName;
    @Column(length = 50, nullable = false)
    private String empEmail;
    @Column(length = 50, nullable = false)
    private String empContact;
    @Column(length = 50, nullable = false)
    private String empAddress;
    @Column(length = 50, nullable = false)
    private String empGender;
    private Date empDOB;
    private String empCode;//pk
//    @Column(length = 50, nullable = false)
//    private String empDepartment;//pk

    @ManyToOne
    @JoinColumn(name = "did_fk")
    Department department;


}