package com.example.User.user;


import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String name;
    private String email;

   /* @OneToOne
    @JoinColumn(name="supervisorId", referencedColumnName = "id", nullable = true)
    private User supervisor;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department dept;*/

}
