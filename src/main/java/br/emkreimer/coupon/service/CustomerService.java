package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository cRepository;

    public void save(Customer customer) {
        // validator
        cRepository.save(customer);
    }
}
