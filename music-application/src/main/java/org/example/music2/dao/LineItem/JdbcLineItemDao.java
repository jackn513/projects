package org.example.music2.dao.LineItem;

import org.example.music2.model.LineItem;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcLineItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        return null;
    }
}
