package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService cService;

    @GetMapping("/list")
    public String listing() {
        return "there will be something here...someday";
    }

    @PostMapping("/save")
    public String save(@RequestBody Customer customer) {
        cService.save(customer);
        return "as i said...someday";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "you really deleted me...";
    }
}
