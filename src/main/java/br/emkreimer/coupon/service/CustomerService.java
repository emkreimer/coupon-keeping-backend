package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository cRepository;

    public List<Customer> listAll() {
        return cRepository.findAllWhileActive();
    }

    public void save(Customer customer) {
        // validator
        cRepository.save(customer);
    }

    public void delete(Long id) {
        Customer c = cRepository.findCustomerById(id);
        c.setActive(false);
        cRepository.save(c);
    }
}
