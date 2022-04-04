package com.example.User.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "dept")
    //@JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> users;
}
