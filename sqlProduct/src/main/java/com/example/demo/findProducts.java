package com.example.demo;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class findProducts implements FindProductInterface {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Product> findAll() {

        String sql = "SELECT * FROM products";

        return jtm.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void deleteById(long id) {

        String sql = "DELETE FROM products WHERE id = ? ";
        int res = jtm.update(sql, id);
        if (res == 0)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product not found"
            );
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void insertProduct(String name, Long Price) {
        //MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "INSERT INTO products(name, Price) VALUES (?, ?)";
        Object[] params = new Object[] {name, Price};

        jtm.update(sql, params);
        //params.addValue("firstName", firstName);
        //params.addValue("lastName", lastName);
        //params.addValue("age", age);
        //jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }
}