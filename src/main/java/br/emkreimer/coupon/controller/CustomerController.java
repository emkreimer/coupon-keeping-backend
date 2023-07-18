package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.dto.CustomerDTO;
import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService cService;

    @GetMapping("/list")
    public List<Customer> listing() {
        return cService.listAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody CustomerDTO customerDTO) {
        cService.save(customerDTO);
        return "as i said...someday";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "you really deleted me...";
    }
}
