package com.neoquant.valid.service;

import com.neoquant.valid.dto.UserRequest;
import com.neoquant.valid.dto.UserResponse;
import com.neoquant.valid.entity.User;
import com.neoquant.valid.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoquant.valid.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User saveUser(UserRequest userRequest) throws UserNotFoundException {
        User u=null;
        if(userRequest.getId() == 0){
             User user=User.
                    build(0,userRequest.getName(), userRequest.getEmail(),
                            userRequest.getMobileNumber(),userRequest.getAge(),userRequest.getNationality());
            System.out.println(user);
            u=userRepo.save(user);
        }else {
            User existingUser=userRepo.findUserById(userRequest.getId());
             User user=User.build(userRequest.getId(),userRequest.getName(), userRequest.getEmail(),
                     userRequest.getMobileNumber(),userRequest.getAge(),userRequest.getNationality());
            System.out.println(user);
            if(user !=null){
                u=userRepo.save(user);
            }else {
                throw new UserNotFoundException("User is not Updated");
            }
        }
        return u;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user=userRepo.findUserById(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("User Not Found with :"+id);
        }
    }

    public void deleteUserById(int id) throws UserNotFoundException {
        User user=userRepo.findById(id).get();
        if(user.getId() == id){
            userRepo.deleteById(id);
        }else {
            throw new UserNotFoundException("We try to delete Id:"+id+" is not found");
        }
    }

}
