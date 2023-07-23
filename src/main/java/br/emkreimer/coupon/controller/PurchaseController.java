package br.emkreimer.coupon.controller;

import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.domain.model.Purchase;
import br.emkreimer.coupon.domain.model.PurchaseListWrapper;
import br.emkreimer.coupon.repository.PurchaseRepository;
import br.emkreimer.coupon.service.ProductService;
import br.emkreimer.coupon.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class PurchaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService pService;

    @Autowired
    private PurchaseRepository pRepository;

    @GetMapping(path = "/")
    public List<Purchase> listCustomerPurchases() {
        return pService.findAll();
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String buy(@RequestBody PurchaseListWrapper purchases, @RequestParam("id") Long idCustomer) {

        List<Purchase> p = pService.savePurchase(purchases.getPurchases(), idCustomer);

        return "é...vai que, né";
    }
}
