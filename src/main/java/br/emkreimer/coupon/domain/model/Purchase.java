package br.emkreimer.coupon.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchases", schema = "public")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;
}
