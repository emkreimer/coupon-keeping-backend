package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.converter.CustomerMapper;
import br.emkreimer.coupon.domain.dto.CustomerDTO;
import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerRepository cRepository;

    @Autowired
    private CustomerMapper cMapper;

    public List<Customer> listAll() {
        return cRepository.findAllWhileActive();
    }

    @Transactional
    public void save(CustomerDTO customerDTO) {
        // validator

        Customer customer = cMapper.toModel(customerDTO);
        List<Product> products = new ArrayList<>();

        for (Long p : customerDTO.getIdProducts()) {
            products.add(productService.findOne(p));
        }

        customer.setProducts(products);
        cRepository.save(customer);
    }

    public void delete(Long id) {
        Customer c = cRepository.findCustomerById(id);
        c.setActive(false);
        cRepository.save(c);
    }
}
