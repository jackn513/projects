package org.example.music2.controller;

import org.example.music2.dao.Sale.SaleDao;
import org.example.music2.model.Sale;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SalesController {

    private final SaleDao saleDao;

    public SalesController(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Sale> getSales(){
        return saleDao.getSales();
    }

    @RequestMapping(method = RequestMethod.POST)
    Sale makeSale(@RequestBody Sale sale){
        return saleDao.createSale(sale);
    }
}
