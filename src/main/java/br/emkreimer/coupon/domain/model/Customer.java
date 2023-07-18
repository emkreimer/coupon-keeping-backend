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

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="purchase", schema="public", joinColumns = @JoinColumn(name="costumer_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products = new ArrayList<>();

    @Column(name="active")
    private boolean active = true;

    //private BigDecimal funds;

}
