package com.example.User.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Name is required")
    private String email;

    @OneToOne
    @JoinColumn(name="supervisorId", referencedColumnName = "id", nullable = true)
    private User supervisor;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department dept;

}
