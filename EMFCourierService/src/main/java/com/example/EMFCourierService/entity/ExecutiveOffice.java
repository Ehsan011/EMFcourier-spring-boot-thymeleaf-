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
    private  String exeName;

    @Column
    private  String exeCell;

    @Column
    private  String exeEmail;

    @Column
    private  String exePassword;

    @Column
    private  String exeAddress;

    @Column
    private  String empId;

}
