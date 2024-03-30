package org.example.music2.dao.Sale;

import org.example.music2.exception.DaoException;
import org.example.music2.model.Album;
import org.example.music2.model.Sale;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcSaleDao implements SaleDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcSaleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "Select * from sale " +
                "JOIN album ON sale.album_id = album.album_id " +
                "JOIN customer on sale.customer_id = customer.customer_id";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                sales.add(mapRowToSale2(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return sales;
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

//        sale_id serial,
//        customer_id int NOT NULL,
//                album_id int NOT NULL,
//                is_sold boolean NOT NULL,
//                sale_date date,
        int saleId;
        String sql = "INSERT INTO sale (customer_id, album_id, is_sold, sale_date) " +
                "values (?, ?, ?, ?) RETURNING sale_id;";
        try {
            saleId = jdbcTemplate.queryForObject(sql, int.class, newSale.getCustomerId(),
                    newSale.getAlbumId(), newSale.getSold(), newSale.getSaleDate());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return getSaleById(saleId);
    }

    @Override
    public Sale updateSale(Sale updatedSale) {
        return null;
    }

    @Override
    public int deleteSaleById(int saleId) {
        return 0;
    }

//    private Sale mapRowToSale(SqlRowSet rowSet){
//        Sale sale = new Sale();
//        sale.setSaleId(rowSet.getInt("sale_id"));
//        sale.setCustomerId(rowSet.getInt("customer_id"));
//        sale.setAlbumId(rowSet.getInt("album_id"));
//        sale.setSold(rowSet.getBoolean("is_sold"));
//        sale.setSaleDate(rowSet.getDate("sale_date").toLocalDate());
//        return sale;
//    }
    private Sale mapRowToSale2(SqlRowSet rowSet){
        Sale sale = new Sale();
        sale.setSaleId(rowSet.getInt("sale_id"));
        sale.setCustomerId(rowSet.getInt("customer_id"));
        sale.setCustomerName(rowSet.getString("customer_name"));
        sale.setAlbumId(rowSet.getInt("album_id"));
        sale.setAlbumName(rowSet.getString("album_title"));
        sale.setSold(rowSet.getBoolean("is_sold"));
        sale.setSaleDate(rowSet.getDate("sale_date").toLocalDate());
        return sale;
    }
}
