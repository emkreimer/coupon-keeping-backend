package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.domain.model.Purchase;
import br.emkreimer.coupon.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository pRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CouponService couponService;

    public List<Purchase> findAll() {
       return (List<Purchase>) pRepository.findAll();
    }
    public void savePurchase(List<Purchase> purchases, Long idCustomer) {

        Customer customer = customerService.findById(idCustomer);
        for (Purchase p : purchases) {
            p.setCustomer(customer);
            p.setProduct(productService.findOne(p.getProduct().getId()));
        }

        couponService.addCouponPoints(purchases, idCustomer);
        pRepository.saveAll(purchases);
    }
}
