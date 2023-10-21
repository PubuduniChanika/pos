package com.spring.pos.pos2.service;


import com.spring.pos.pos2.dto.CustomerDto;
import com.spring.pos.pos2.dto.request.CustomerUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerUpdateDto customerUpdateDto);

    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomers();

    String deleteCustomerById(int customerId);

    List<CustomerDto> getAllCustomersByActiveState(boolean activeState);
}
