package com.dkelly205.kafka_demo.services;

import com.dkelly205.kafka_demo.entity.CustomerEntity;
import com.dkelly205.kafka_demo.entity.OrderEntity;
import com.dkelly205.kafka_demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public void saveOrder(BigDecimal totalAmount, CustomerEntity customer) {
        OrderEntity order = OrderEntity.builder().totalAmount(totalAmount)
                .customer(customer)
                .build();
        orderRepository.save(order);
    }
}
