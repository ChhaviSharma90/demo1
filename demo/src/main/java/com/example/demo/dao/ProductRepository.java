package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Product;
@Repository
public class ProductRepository {
    @Autowired

    JdbcTemplate jdbcTemplate;

    class ProductRowMapper implements RowMapper < Product > {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

            Product prod = new Product();
            prod.setProductId(rs.getString("productid"));
            prod.setProductName(rs.getString("productname"));
            prod.setProductDesc(rs.getString("productdesc"));
           

            return prod;

        }

		

    }

    public List < Product > findAll() {
    	System.out.println("Entered findAll method");

        return jdbcTemplate.query("select * from product", new ProductRowMapper());

    }

    public Product findById(String id) {

        return jdbcTemplate.queryForObject("select * from product where productid=?", new Object[] {

                id

            },

            new BeanPropertyRowMapper < Product > (Product.class));

    }

    public int deleteById(String id) {
    	System.out.println("Entered Delete");

        return jdbcTemplate.update("delete from product where productid=?", new Object[] { id });

    }

    public int insert(Product prod) {
    	System.out.println("Entered insert");

        return jdbcTemplate.update("insert into product (productid, productname, productdesc) " + "values(?,  ?, ?)",

            new Object[] {

              prod.getProductId(),prod.getProductName(),prod.getProductDesc()

            });

    }

    public int update(Product prod) {
		
System.out.println("Entered update ");
        return jdbcTemplate.update("update product set productname = ?  where productid = ?",

            new Object[] {

              prod.getProductName(),prod.getProductId()

            });
    	
    }

}
