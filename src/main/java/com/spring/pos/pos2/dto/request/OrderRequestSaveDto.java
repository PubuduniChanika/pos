package com.spring.pos.pos2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderRequestSaveDto {
    private Date orderDate;
    private double orderTotal;
    private int customer;
    private List<ItemOrderRequestSaveDto> item_orders;

}

