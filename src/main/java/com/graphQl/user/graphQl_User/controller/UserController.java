package com.graphQl.user.graphQl_User.controller;

import com.graphQl.user.graphQl_User.dto.Order;
import com.graphQl.user.graphQl_User.entity.User;
import com.graphQl.user.graphQl_User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserService userService;

    @QueryMapping
    public List<User> allUser() {
        return userService.getAllUsers();
    }

    @SchemaMapping(typeName = "User", field = "orders")
    public List<Order> getOrders(User user) {
        String url = "http://localhost:8080/graphql";
        String query = "{ allOrder { orderId userId amount } }";

        Map<String, Object> request = Map.of("query", query);
        Map<String, Object> response = restTemplate.postForObject(url, request, Map.class);

        List<Map<String, Object>> allOrders = (List<Map<String, Object>>)((Map)response.get("data")).get("allOrder");

        return allOrders.stream()
                .filter(o -> o.get("userId").equals(user.getId()))
                .map(o -> new Order(
                        (String)o.get("orderId"),
                        (String)o.get("userId"),
                        ((Number)o.get("amount")).doubleValue()))
                .collect(Collectors.toList());
    }
}
