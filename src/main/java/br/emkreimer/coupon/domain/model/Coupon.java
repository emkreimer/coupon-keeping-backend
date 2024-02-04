package br.emkreimer.coupon.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "coupon", schema = "public")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="points")
    private int points;

    @Column(name="complete")
    private boolean complete = false;

}
