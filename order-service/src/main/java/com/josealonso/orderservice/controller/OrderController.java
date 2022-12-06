package com.josealonso.orderservice.controller;

import com.josealonso.orderservice.dto.OrderRequest;
import com.josealonso.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

    // must return the same type and receive the same params as the "placeOrder" method
    public String fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return "Something went wrong, please order after some time!";
    }
}
