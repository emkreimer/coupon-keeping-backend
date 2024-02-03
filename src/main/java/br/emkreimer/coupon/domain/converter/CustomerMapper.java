package br.emkreimer.coupon.domain.converter;

import br.emkreimer.coupon.domain.dto.CustomerDTO;
import br.emkreimer.coupon.domain.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toModel(CustomerDTO customerDTO);

    CustomerDTO toDto(Customer customer);

    List<CustomerDTO> toListDto(List<Customer> customers);
}
