package com.example.manageuser.Service;

import com.example.manageuser.Entity.User;
import com.example.manageuser.Exception.NotFoundException;
import com.example.manageuser.Model.Dto.UserDto;
import com.example.manageuser.Model.Mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private static ArrayList<User> users=new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com","0987654321","avatar.img","123"));
        users.add(new User(2, "Bùi Như Lạc", "laclac@gmail.com","0123456789","avatar1.img","123"));
        users.add(new User(3, "Phan Thị Lỏng Lẻo", "longleo@gmail.com","0987564664","avatar3.img","123"));
        users.add(new User(4, "Bành Thị Tèo", "teo@gmail.com","0874845455","avatar9.img","123"));
    }

    @Override
    public List<UserDto> getListUser() {
        ArrayList<UserDto> result=new ArrayList<UserDto>();
        for (User user:users) {
            result.add(UserMapper.toUser(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for(User user:users){
            if(user.getId()==id){
                return UserMapper.toUser(user);
            }
        }
        throw new NotFoundException("UserId is not exist");
    }

    @Override
    public List<UserDto> searchUser(String name) {
        ArrayList<UserDto> result=new ArrayList<UserDto>();
        for(User user:users){
            if(user.getName().contains(name)) {
                result.add(UserMapper.toUser(user));
            }
        }
        if(result.isEmpty())
            throw new NotFoundException("UserName is not exist");
        return result;
    }
}
