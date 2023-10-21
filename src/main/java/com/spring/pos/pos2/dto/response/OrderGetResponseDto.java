package com.spring.pos.pos2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetResponseDto {
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;
    private Date orderDate;
    private double orderTotal;
}
