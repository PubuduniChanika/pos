package com.spring.pos.pos2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "full_order")
public class Order {
    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;
    @Column(name = "order_total")
    private double orderTotal;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<Item_Order> item_orders;

    public Order(Date orderDate, double orderTotal, Customer customer) {
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.customer = customer;
    }
}
