package org.idb.emf.EMFCourier.entity;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_data")
public class Employee {

    private int id;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empContact;
    private String empAddress;
    private String empGender;
    private String empDOB;


}