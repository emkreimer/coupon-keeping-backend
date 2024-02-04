package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String secretToken;

    public String generateToken(User user) {
        return null;
    }
}
