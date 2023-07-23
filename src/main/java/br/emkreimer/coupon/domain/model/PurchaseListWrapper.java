package br.emkreimer.coupon.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseListWrapper {

    private List<Purchase> purchases;
}
