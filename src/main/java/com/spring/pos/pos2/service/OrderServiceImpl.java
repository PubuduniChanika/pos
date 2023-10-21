package com.spring.pos.pos2.service;

import com.spring.pos.pos2.dto.CustomerDto;
import com.spring.pos.pos2.dto.paginated.PaginatedResponseOrderDto;
import com.spring.pos.pos2.dto.queryinterfaces.OrderDetailsInterface;
import com.spring.pos.pos2.dto.request.ItemOrderRequestSaveDto;
import com.spring.pos.pos2.dto.request.OrderRequestSaveDto;
import com.spring.pos.pos2.dto.response.ItemGetResponseDto;
import com.spring.pos.pos2.dto.response.OrderGetResponseDto;
import com.spring.pos.pos2.entity.Customer;
import com.spring.pos.pos2.entity.Item;
import com.spring.pos.pos2.entity.Item_Order;
import com.spring.pos.pos2.entity.Order;
import com.spring.pos.pos2.repository.CustomerRepository;
import com.spring.pos.pos2.repository.ItemOrderRepository;
import com.spring.pos.pos2.repository.ItemRepository;
import com.spring.pos.pos2.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemOrderRepository itemOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public String saveItem(OrderRequestSaveDto orderRequestSaveDto) {
        Order order = new Order(
                orderRequestSaveDto.getOrderDate(),
                orderRequestSaveDto.getOrderTotal(),
                customerRepository.getReferenceById(orderRequestSaveDto.getCustomer())
        );
            orderRepository.save(order);
            if(orderRepository.existsById(order.getOrderId())){
                List<Item_Order> itemOrder = modelMapper.map(orderRequestSaveDto.getItem_orders(), new TypeToken<List<Item_Order>>(){}.getType());
                for(int i=0; i<itemOrder.size(); i++){
                    itemOrder.get(i).setOrder(order);
                    itemOrder.get(i).setItem(itemRepository.getReferenceById(orderRequestSaveDto.getItem_orders().get(i).getItem()));
                }
                if(itemOrder.size()>0){
                    itemOrderRepository.saveAll(itemOrder);
                }
            }
return "saved!!!";


    }

    @Override
    public PaginatedResponseOrderDto getOrderByStatusPaginated(boolean activeState, int page, int size) {
        List<OrderDetailsInterface> orderGetResponseDtos = orderRepository.getAllOrderDetails(activeState, PageRequest.of(page, size));
//        System.out.println(orderGetResponseDtos.get(0).getCustomerName());
        List<OrderGetResponseDto> list = new ArrayList<>();
        for (OrderDetailsInterface o: orderGetResponseDtos){
            OrderGetResponseDto r = new OrderGetResponseDto(
                    o.getCustomerName(),
                    o.getCustomerPhoneNumber(),
                    o.getCustomerAddress(),
                    o.getOrderDate(),
                    o.getOrderTotal()
            );
            list.add(r);
        }
        PaginatedResponseOrderDto paginatedResponseOrderDto = new PaginatedResponseOrderDto(list,orderRepository.CountAllOrders(activeState));
return paginatedResponseOrderDto;
    }
}
