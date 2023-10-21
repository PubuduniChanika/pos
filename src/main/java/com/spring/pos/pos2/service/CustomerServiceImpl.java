package com.spring.pos.pos2.service;


//import com.example.pos_system_1.util.mappers.CustomerMapper;
import com.spring.pos.pos2.dto.CustomerDto;
import com.spring.pos.pos2.dto.request.CustomerUpdateDto;
import com.spring.pos.pos2.entity.Customer;
import com.spring.pos.pos2.exception.NotFoundException;
import com.spring.pos.pos2.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import java.awt.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
//    @Autowired
//    private CustomerMapper customerMapper;


    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
        return "Saved!!!";
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if(customerRepository.existsById(customerUpdateDto.getCustomerId())) {
            Customer customer = customerRepository.getReferenceById(customerUpdateDto.getCustomerId());
            customer.setCustomerName(customerUpdateDto.getCustomerName());
            customer.setNic(customerUpdateDto.getNic());
            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());

            customerRepository.save(customer);
            return customerUpdateDto.getCustomerName()+" updated successfully";

        }else{
            throw new RuntimeException("No data for that id");
        }

    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        if(allCustomers.size()>0) {
            List<CustomerDto> customerDtos = modelMapper.map(allCustomers, new TypeToken<List<CustomerDto>>() {
            }.getType());
            //List<CustomerDto> customerDtos = customerMapper.entityListToDtoList(allCustomers);
            return customerDtos;
        }else{
            throw new NotFoundException("Customer Not Found");
        }
    }

    @Override
    public String deleteCustomerById(int customerId) {
        if(customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return "Deleted "+customerId;
        }
        else{
            return "No Customer Available for Id "+customerId;
        }
    }

    @Override
    public List<CustomerDto> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> allCustomers = customerRepository.findAllByActiveEquals(activeState);
        List<CustomerDto> customerDtos = modelMapper.map(allCustomers, new TypeToken<List<CustomerDto>>(){}.getType());
        //List<CustomerDto> customerDtos = customerMapper.entityListToDtoList(allCustomers);
        return customerDtos;

    }
}
