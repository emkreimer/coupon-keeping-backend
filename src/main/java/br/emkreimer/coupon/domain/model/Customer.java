package br.emkreimer.coupon.domain.model;

import jakarta.persistence.*;
import lombok.Data;

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

}
