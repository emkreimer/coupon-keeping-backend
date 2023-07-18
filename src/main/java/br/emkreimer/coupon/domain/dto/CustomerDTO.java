package br.emkreimer.coupon.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private Long id;
    private String name;
    private List<Long> idProducts;
}
