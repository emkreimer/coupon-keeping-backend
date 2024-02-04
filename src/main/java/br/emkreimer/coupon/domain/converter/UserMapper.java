package br.emkreimer.coupon.domain.converter;

import br.emkreimer.coupon.domain.dto.UserDTO;
import br.emkreimer.coupon.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", ignore = true)
    User toModel(UserDTO userDto);

    @Mapping(target = "role", ignore = true)
    UserDTO toDto(User user);

}
