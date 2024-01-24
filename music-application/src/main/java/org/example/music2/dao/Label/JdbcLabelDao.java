package org.example.music2.dao.Label;

import org.example.music2.model.Label;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcLabelDao implements LabelDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcLabelDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Label getLabelById(int labelId) {
        return null;
    }


}
