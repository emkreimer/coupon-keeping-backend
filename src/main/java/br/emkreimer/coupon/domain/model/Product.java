package br.emkreimer.coupon.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="product", schema="public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="label")
    private String label;

    @Column(name="price")
    private BigDecimal price;
}