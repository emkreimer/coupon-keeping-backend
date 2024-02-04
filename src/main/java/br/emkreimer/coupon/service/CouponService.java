package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Coupon;
import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.domain.model.Purchase;
import br.emkreimer.coupon.repository.CouponRepository;
import br.emkreimer.coupon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

@Service
public class CouponService {

    @Autowired
    private CouponRepository cRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Value("${MAX_VALUE}")
    private BigDecimal max;

    @Value("${STANDARD_VALUE}")
    private BigDecimal min;

    @Value("${MAX_POINTS}")
    private int maxPoints;

    public void addCouponPoints(List<Purchase> purchases, Long idCustomer) {

        BigDecimal totalSpent = sumSpending(purchases);
        if (totalSpent.compareTo(min) == 0 || totalSpent.compareTo(min) == 1) {
            assignPoints(totalSpent, idCustomer);
        }
    }

    public BigDecimal sumSpending(List<Purchase> purchases) {

        BigDecimal totalSpent =  BigDecimal.ZERO;
        for (Purchase p: purchases) {
            BigDecimal price = p.getProduct().getPrice();
            BigDecimal moneySpent = price.multiply(BigDecimal.valueOf(p.getQuantity()));
            totalSpent = totalSpent.add(moneySpent);
        }
        return totalSpent;
    }

    public void assignPoints(BigDecimal totalSpent, Long id) {

        int newPoints = totalSpent.divide(min).intValue();
        Coupon coupon = cRepository.findByCustomer(id);

        if (coupon == null) {
            Customer customer = customerRepository.findCustomerById(id);
            newCoupon(newPoints, customer);
        }

        int totalPoints = coupon.getPoints() + newPoints;
        coupon.setPoints(totalPoints);
        save(coupon);
    }

    public void newCoupon(int points, Customer customer) {

        Coupon coupon = new Coupon();
        coupon.setPoints(points);
        coupon.setCustomer(customer);
        save(coupon);
    }

    public void save(Coupon coupon) {

        if (coupon.getPoints() > maxPoints) {
            coupon.setPoints(maxPoints);
            coupon.setComplete(true);
            newCoupon(coupon.getPoints() - maxPoints, coupon.getCustomer());
        } else {
            coupon.setPoints(coupon.getPoints());
        }
        cRepository.save(coupon);
    }
}
