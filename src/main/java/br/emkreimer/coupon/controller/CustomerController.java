package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.dto.CustomerDTO;
import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService cService;

    @GetMapping("/list")
    public ResponseEntity<?> listing() {
        return new ResponseEntity<>(cService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody CustomerDTO customerDTO) {
        cService.save(customerDTO);
        return new ResponseEntity<>("Salvo!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return  new ResponseEntity<>("you really deleted me...", HttpStatus.OK);
    }
}
