package com.dkelly205.kafka_demo.services;

import com.dkelly205.kafka_demo.dto.OrderRequest;
import com.dkelly205.kafka_demo.entity.CustomerEntity;
import com.dkelly205.kafka_demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerEntity saveCustomer(OrderRequest orderRequest) {

        return customerRepository.findByEmail(orderRequest.getCustomerEmail()).orElseGet(
                () -> {
                    CustomerEntity customerEntity = CustomerEntity.builder()
                            .firstName(orderRequest.getCustomerFirstName())
                            .lastName(orderRequest.getCustomerLastName())
                            .email(orderRequest.getCustomerEmail())
                            .addressLine1(orderRequest.getCustomerAddressLine1())
                            .addressLine2(orderRequest.getCustomerAddressLine2())
                            .town(orderRequest.getCustomerTown())
                            .postCode(orderRequest.getCustomerPostCode())
                            .build();

                    return customerRepository.save(customerEntity);
                });
    }
}
