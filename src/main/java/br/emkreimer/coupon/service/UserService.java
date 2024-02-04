package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.converter.UserMapper;
import br.emkreimer.coupon.domain.dto.UserDTO;
import br.emkreimer.coupon.domain.enums.UserRole;
import br.emkreimer.coupon.domain.model.User;
import br.emkreimer.coupon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserDTO userDTO) {
        String hashedPassword = bCryptPasswordEncoder.encode(userDTO.password());

        User user = mapper.toModel(userDTO);
        user.setPassword(hashedPassword);
        if (userDTO.role().equals(UserRole.ADMIN.getRole())) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.CUSTOMER);
        }

        userRepository.save(user);
    }

    public User getByLogin(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }
}
