package br.emkreimer.coupon.repository;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.domain.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
