package com.spring.pos.pos2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDto {
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;
    //    @Column(name = "contact_numbers",length = 10)
//    private ArrayList contactNumber;
    private String nic;

}
