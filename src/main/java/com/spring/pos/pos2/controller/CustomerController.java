package com.spring.pos.pos2.controller;


import com.spring.pos.pos2.dto.CustomerDto;
import com.spring.pos.pos2.dto.request.CustomerUpdateDto;
import com.spring.pos.pos2.dto.request.ItemSaveRequestDto;
import com.spring.pos.pos2.service.CustomerService;
import com.spring.pos.pos2.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
        String message = customerService.saveCustomer(customerDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.CREATED
        );
    }


    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto) {
        String message = customerService.updateCustomer(customerUpdateDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDto message = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDto> message = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-by-id", params = "id")
    public ResponseEntity<StandardResponse> deleteCustomerById(@RequestParam(value = "id") int customerId) {
        String message = customerService.deleteCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-customers-by-active-state/{status}")
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@RequestParam(value = "status") boolean activeState) {
        List<CustomerDto> message = customerService.getAllCustomersByActiveState(activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }
}


