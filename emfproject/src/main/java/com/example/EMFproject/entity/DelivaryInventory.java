package com.example.EMFproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class DelivaryInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inventory_id;

    @Column
    int inventory_order_staus;

    @ManyToOne
    @JoinColumn(name="delivaryMan_id_fk")
    DelivaryManDetails delivaryManDetails;

    @ManyToOne
    @JoinColumn(name="Order_id_fk")
    OrderDetails orderDetails;
}
