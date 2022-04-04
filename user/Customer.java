package com.example.User.user;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    private long id;
    private String customer_name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "customers_items",
            joinColumns = {
                    @JoinColumn(name = "customer_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "item_id", referencedColumnName = "id")})
    private List<Item> items = new ArrayList<>();
}
