package com.example.pao_lab4_e1.repository;

import com.example.pao_lab4_e1.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
  @Value("${db.url}")
  private String url;
  @Value("${db.username}")
  private String username;
  @Value("${db.password}")
  private String password;

  public void addProduct(Product product) {
    String sql = "insert into product values (NULL, ?, ?)";

    try (Connection con = DriverManager.getConnection(url, username, password)) {
      var statement = con.prepareStatement(sql);
      statement.setString(1, product.getName());
      statement.setBigDecimal(2, product.getPrice());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Product> getProducts() {
    String sql = "select * from product";
    List<Product> list = new ArrayList<Product>();

    try (Connection con = DriverManager.getConnection(url, username, password)) {
      var statement = con.prepareStatement(sql);
      ResultSet res = statement.executeQuery();

      while (res.next()) {
        Product product = new Product();

        product.setId(res.getInt("id"));
        product.setName(res.getString("name"));
        product.setPrice(res.getBigDecimal("price"));

        list.add(product);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }
}
