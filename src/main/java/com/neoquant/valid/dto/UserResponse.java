package com.neoquant.valid.dto;

import com.neoquant.valid.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {

    private String result;
    private String message;
    private boolean status;
    private User user;
    private List<User> userList;
}
