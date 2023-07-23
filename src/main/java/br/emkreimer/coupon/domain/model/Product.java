package br.emkreimer.coupon.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name="supply")
    private int supply;

    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = Purchase.class, fetch = FetchType.LAZY)
    private List<Purchase> purchases = new ArrayList<>();
}
