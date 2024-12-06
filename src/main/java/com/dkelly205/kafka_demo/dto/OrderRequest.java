package com.dkelly205.kafka_demo.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderRequest {
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerAddressLine1;
    private String customerAddressLine2;
    private String customerTown;
    private String customerPostCode;
    private BigDecimal totalAmount;
}
