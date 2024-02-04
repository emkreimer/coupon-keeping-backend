package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.dto.UserDTO;
import br.emkreimer.coupon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);

        // exception handling coming soon
        return new ResponseEntity<>("Novo usuário!!", HttpStatus.OK);
    }

}
