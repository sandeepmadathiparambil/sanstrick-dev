package com.example.sanstrick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/servertime")
public class ServerTimeController {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Inject the JdbcTemplate for database connectivity

    @GetMapping
    public Map<String, Object> getServerTime() {
        Map<String, Object> response = new HashMap<>();

        try {
            // Attempt to execute a simple query to the database to check connectivity
            jdbcTemplate.queryForObject("SELECT NOW()", String.class);

            // If the query succeeds, fetch the current server time
            String currentTime = jdbcTemplate.queryForObject("SELECT NOW()", String.class);

            response.put("status", "success");
            response.put("message", "Connected to the database");
            response.put("serverTime", currentTime);
        } catch (Exception e) {
            // If there is an exception, handle the database connection error
            response.put("status", "error");
            response.put("message", "Database connection error");
            response.put("error", e.getMessage());
        }

        return response;
    }
}
