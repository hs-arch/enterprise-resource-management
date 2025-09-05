package com.example.enterprise_resource_management.controller;

import com.example.enterprise_resource_management.dto.CreateOrderRequest;
import com.example.enterprise_resource_management.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody CreateOrderRequest orderRequest){



        return ResponseEntity.ok();
    }

}
