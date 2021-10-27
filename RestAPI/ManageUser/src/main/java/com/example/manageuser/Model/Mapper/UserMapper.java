package com.example.manageuser.Model.Mapper;

import com.example.manageuser.Entity.User;
import com.example.manageuser.Model.Dto.UserDto;

public class UserMapper {
    public static UserDto toUser(User user){
        UserDto tmp=new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        return tmp;
    }
}
