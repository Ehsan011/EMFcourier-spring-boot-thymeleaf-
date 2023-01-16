package org.idb.emf.EMFCourier.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CorporateToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenid;
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = CorporateCustomer.class)
    @JoinColumn(name = "ccuser_id", nullable = false)
    private CorporateCustomer user;

    public CorporateToken(CorporateCustomer user) {
        this.confirmationToken = UUID.randomUUID().toString();
        this.createdDate = new Date();
        this.user = user;
    }
}
