package br.emkreimer.coupon.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="customer", schema="public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="active")
    private boolean active = true;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", targetEntity = Purchase.class, fetch = FetchType.LAZY)
    private List<Purchase> purchases;

}
