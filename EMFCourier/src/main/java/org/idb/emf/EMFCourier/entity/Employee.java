package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {

    private int id;
    private String empFirstName ;
    private String empLastName;
    private String empEmail;
    private String empContact;
    private String empAddress;
    private String empGender;
    private String empDOB;
    

}
