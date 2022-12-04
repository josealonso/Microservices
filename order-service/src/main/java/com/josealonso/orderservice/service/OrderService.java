package com.josealonso.orderservice.service;

import com.josealonso.orderservice.dto.OrderLineItemsDto;
import com.josealonso.orderservice.dto.OrderRequest;
import com.josealonso.orderservice.model.Order;
import com.josealonso.orderservice.model.OrderLineItems;
import com.josealonso.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    public static final String API_INVENTORY = "http://localhost:8082/api/inventory";
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        var orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToEntity)
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);

        // Place order if product is in stock
        Boolean result = webClient.get()
                .uri(API_INVENTORY)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (result) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToEntity(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}


























