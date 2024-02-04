package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.dto.AuthDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authentication")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO auth) {
        return null;
    }
}
