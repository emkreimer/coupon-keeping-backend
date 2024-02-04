package br.emkreimer.coupon.domain.dto;

import br.emkreimer.coupon.domain.enums.UserRole;

public record UserDTO(String login, String password, String role) {
}
