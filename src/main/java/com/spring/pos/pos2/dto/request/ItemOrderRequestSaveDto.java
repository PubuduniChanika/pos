package com.spring.pos.pos2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrderRequestSaveDto {
    int item;
    private int qty;
    private double amount;
}
