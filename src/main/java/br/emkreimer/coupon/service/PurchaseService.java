package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Customer;
import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.domain.model.Purchase;
import br.emkreimer.coupon.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository pRepository;

    @Autowired
    private CustomerService customerService;

    public List<Purchase> findAll() {
       return (List<Purchase>) pRepository.findAll();
    }
    public List<Purchase> savePurchase(List<Purchase> purchases, Long idCustomer) {

        Customer customer = customerService.findById(idCustomer);
        for (Purchase p : purchases) {
            p.setCustomer(customer);
        }
        return (List<Purchase>) pRepository.saveAll(purchases);
    }

    public void isCouponWorthy() {
        //        Purchase purchase = new Purchase();
//        BigDecimal moneySpent = BigDecimal.ZERO;
//        for (Product p : purchases) {
//            moneySpent = moneySpent.add(p.getPrice());
//        }
    }
}
