package br.emkreimer.coupon.repository;

import br.emkreimer.coupon.domain.model.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    @Query("SELECT c FROM Coupon c WHERE c.customer.id = ?1 AND c.complete = false")
    public Coupon findByCustomer(Long id);
}
