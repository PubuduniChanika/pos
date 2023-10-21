package com.spring.pos.pos2.repository;

import com.spring.pos.pos2.entity.Item;
import com.spring.pos.pos2.entity.Item_Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<Item_Order, Integer> {
}
