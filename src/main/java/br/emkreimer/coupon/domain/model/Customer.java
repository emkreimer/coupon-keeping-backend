package br.emkreimer.coupon.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

}
