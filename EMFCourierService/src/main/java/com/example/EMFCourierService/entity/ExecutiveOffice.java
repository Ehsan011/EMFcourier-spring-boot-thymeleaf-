package com.example.EMFCourierService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecutiveOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private  String excName;

    @Column
    private  String excCell;

    @Column
    private  String excEmail;

    @Column
    private  String excPassword;

    @Column
    private  String excAddress;

    @Column
    private  String empId;

}
