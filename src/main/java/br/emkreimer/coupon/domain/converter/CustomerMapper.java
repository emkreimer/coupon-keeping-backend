package br.emkreimer.coupon.domain.converter;

import br.emkreimer.coupon.domain.dto.CustomerDTO;
import br.emkreimer.coupon.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toModel(CustomerDTO customerDTO);

    CustomerDTO toDto(Customer customer);
}
