package com.spring.pos.pos2.entity;

//import com.vladmihalcea.hibernate.type.json.JsonType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
//import org.hibernate.annotations.TypeDef;
//import org.hibernate.annotations.TypeDefs;
import java.util.ArrayList;
import java.util.Set;


//@TypeDefs({
//@TypeDef(name = "json", typeClass = JsonType.class)
//})

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @Column(name = "customer_id",length = 45)
    private int customerId;
    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;
    @Column(name = "customer_phone_number",length = 100,nullable = false)
    private String customerPhoneNumber;
    @Column(name = "customer_address",length = 255)
    private String customerAddress;
//    @Column(name = "contact_numbers",length = 10,columnDefinition = "json")
//    @Type(type = "json")
//    private ArrayList contactNumber;
    @Column(name = "nic",length = 12)
    private String nic;
    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private boolean active;
    @OneToMany(mappedBy="customer")
    private Set<Order> orders;

}
