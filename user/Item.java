package com.example.User.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Item {
    @Id
    private long id;
    private String item_name;

    @ManyToMany(mappedBy = "items")
    private List<Customer> customers;
}
