package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shopping")
public class PurchaseController {

    @Autowired
    private ProductService pService;

    @GetMapping(path = "/products")
    public List<Product> listProductsAvailable() {
        return pService.listAll();
    }

    @PostMapping(path = "/buy")
    public String buy(@RequestBody Product products, @RequestParam("id") Long customerId) {
        return null;
    }
}
