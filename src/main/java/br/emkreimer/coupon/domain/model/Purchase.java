package br.emkreimer.coupon.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases", schema = "public")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;
}
