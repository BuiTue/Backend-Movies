package com.example.cinema1.Modal.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
public class UserTotal {
    private int id;
    private String username;
    private String productName;
    private int totalQuantity;

    public UserTotal(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.username = resultSet.getString("username");
        this.productName = resultSet.getString("product_name");
        this.totalQuantity = resultSet.getInt("total_quantity");
    }
}
