package org.example.music2.dao.Sale;

import org.example.music2.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Sale getSaleById(int saleId) {
        return null;
    }

    @Override
    public List<Sale> getUnsoldSales() {
        return null;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        return null;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        return null;
    }

    @Override
    public Sale createSale(Sale newSale) {
        return null;
    }

    @Override
    public Sale updateSale(Sale updatedSale) {
        return null;
    }

    @Override
    public int deleteSaleById(int saleId) {
        return 0;
    }
}
