package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService pService;

    @GetMapping(path = "/list")
    public ResponseEntity<?> listing() {
        return new ResponseEntity<>(pService.listAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> save(@RequestBody Product product) {
        pService.save(product);
        return new ResponseEntity<>("Deu certo!", HttpStatus.OK);
    }
}
