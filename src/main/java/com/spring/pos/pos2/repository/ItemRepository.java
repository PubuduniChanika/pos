package com.spring.pos.pos2.repository;

import com.spring.pos.pos2.entity.Customer;
import com.spring.pos.pos2.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEqualsAndActiveEquals(String itemName, boolean status);
    List<Item> findAllByActiveEquals(boolean status);
    Page<Item> findAllByActiveEquals(boolean status, Pageable pageable);

    int countAllByActiveEquals(boolean activeState);
}
