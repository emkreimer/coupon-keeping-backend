package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService pService;

    @GetMapping(path = "/list")
    public List<Product> listing() {
        return null;
    }

    @PostMapping(path = "/save")
    public String save(@RequestBody Product product) {
        pService.save(product);
        return "...who knows, huh?";
    }
}
