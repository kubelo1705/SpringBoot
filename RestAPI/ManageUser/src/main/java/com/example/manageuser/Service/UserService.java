package com.example.manageuser.Service;

import com.example.manageuser.Entity.User;
import com.example.manageuser.Model.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String name);

}
