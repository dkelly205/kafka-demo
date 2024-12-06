package com.dkelly205.kafka_demo.controller;


import com.dkelly205.kafka_demo.dto.OrderRequest;
import com.dkelly205.kafka_demo.services.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest){
        orderFacade.saveOrderAndCustomer(orderRequest);
        return ResponseEntity.ok("Order and Customer saved successfully");
    }

}
