package com.example.User.service;

import com.example.User.repository.*;
import com.example.User.user.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Services {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DeprtmentRepository deptRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;

    public User  saveUser(User user){
     return  userRepository.save(user);
    }

    public List<User> getAllusers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

   /* public User update(User user, long id){
        List list = new ArrayList<String>();
        list = list.stream().map(u->{
            u.setName(user.getName());
        })
        return user;
    }*/
    // saving dept.
    public Department saveDept(Department dept){
        return deptRepository.save(dept);
    }

    // saving student
    public Student saveStudent(Student st){
        return studentRepository.save(st);
    }
    // saving courses
    public Course saveCourse(Course curs){
        return courseRepository.save(curs);
    }

    //saving customer

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    //saving item
    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    //pagination
    public Page<User> find(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public List<UserDTO> getUsers(int page, int limit){
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();

        Pageable pageable = PageRequest.of(page, limit);
        Page<User> usersPage = userRepository.findAll(pageable);

        List<User> userList = usersPage.getContent();

        for(User user: userList){
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    // pagination and sorting

    public Page<User> userPaginated(int pageNo, int pageSize, String sortField, String sortDirection){

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?  Sort.by(sortField).ascending():
        Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        return userRepository.findAll(pageable);
    }
}

