package com.graphQl.user.graphQl_User.entity;

import com.graphQl.user.graphQl_User.dto.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "app_user")
public class User {

    @Id
    private String id;
    private String name;
    private String email;

    @Transient
    private List<Order> orders;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
