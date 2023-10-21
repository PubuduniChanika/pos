package com.spring.pos.pos2.dto.queryinterfaces;

import java.util.Date;

public interface OrderDetailsInterface {
    String getCustomerName();
    String getCustomerPhoneNumber();
    String getCustomerAddress();
    Date getOrderDate();
    double getOrderTotal();
}
