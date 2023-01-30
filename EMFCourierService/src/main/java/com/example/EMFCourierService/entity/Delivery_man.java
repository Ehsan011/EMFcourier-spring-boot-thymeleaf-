package com.example.EMFCourierService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery_man {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int heroId;

    @Column
    private  String heroName;

    @Column
    private  String heroCell;

    @Column
    private  String heroEmail;

    @Column
    private  String heroPassword;

    @Column
    private  String heroAddress;

}
