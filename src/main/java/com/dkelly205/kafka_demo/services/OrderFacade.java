package com.dkelly205.kafka_demo.services;

import com.dkelly205.kafka_demo.dto.OrderRequest;
import com.dkelly205.kafka_demo.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Transactional
    public void saveOrderAndCustomer(OrderRequest orderRequest) {

        // Save Customer
        CustomerEntity customer = customerService.saveCustomer(orderRequest);

        // Save Order
        orderService.saveOrder(orderRequest.getTotalAmount(), customer);
    }
}

