package com.spring.pos.pos2.repository;

import com.spring.pos.pos2.dto.queryinterfaces.OrderDetailsInterface;
import com.spring.pos.pos2.dto.response.OrderGetResponseDto;
import com.spring.pos.pos2.entity.Item;
import com.spring.pos.pos2.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value="select c.customer_name as customerName,c.customer_address as customerAddress,c.contact_number as customerPhoneNumber,o.order_date as orderDate,o.order_total as orderTotal from customer c,full_order o where c.active_state = ?1 and o.customer_id=c.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean activeState, PageRequest of);
    @Query(value="select count(*) from customer c,full_order o where c.active_state = ?1 and o.customer_id=c.customer_id",nativeQuery = true)
    long CountAllOrders(boolean activeState);
}
