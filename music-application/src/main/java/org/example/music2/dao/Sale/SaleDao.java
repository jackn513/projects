package org.example.music2.dao.Sale;

import org.example.music2.model.Sale;

import java.util.List;

public interface SaleDao {
    List<Sale> getSales();
    Sale getSaleById(int saleId);
    List<Sale> getUnsoldSales();
    List<Sale> getSalesByCustomerId(int customerId);
    List<Sale> getSalesByProductId(int productId);
    Sale createSale(Sale newSale);
    Sale updateSale(Sale updatedSale);
    int deleteSaleById(int saleId);
}
