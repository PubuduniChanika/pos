package com.spring.pos.pos2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;
    //    @Column(name = "contact_numbers",length = 10)
//    private ArrayList contactNumber;
    private String nic;
    private boolean active;
}
