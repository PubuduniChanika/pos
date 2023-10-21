package com.spring.pos.pos2.repository;


import com.spring.pos.pos2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByActiveEquals(boolean activeState);
}
