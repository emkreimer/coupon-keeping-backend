package br.emkreimer.coupon.repository;

import br.emkreimer.coupon.domain.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.id = ?1 AND c.active = true")
    public Customer findCustomerById(Long id);

    @Query("SELECT c FROM Customer c WHERE c.active = true")
    public List<Customer> findAllWhileActive();
}
