package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.dto.AuthDTO;
import br.emkreimer.coupon.domain.dto.UserDTO;
import br.emkreimer.coupon.service.AuthService;
import br.emkreimer.coupon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO auth) {
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(auth.login(), auth.password());
        Authentication authentication = authenticationManager.authenticate(user);
        //assign token
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/new")
    public ResponseEntity register(@RequestBody UserDTO newUser) {
        try {
            userService.getByLogin(newUser.login());
            userService.save(newUser);
            return ResponseEntity.ok().build();
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
