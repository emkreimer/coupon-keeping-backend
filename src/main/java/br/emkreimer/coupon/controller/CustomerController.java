package br.emkreimer.coupon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/list")
    public String listing() {
        return "there will be something here...someday";
    }

    @PostMapping("/save")
    public String save(String str) {
        return "as i said...someday";
    }
}
