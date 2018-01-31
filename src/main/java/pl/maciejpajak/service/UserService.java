package pl.maciejpajak.service;

import java.util.List;

import pl.maciejpajak.dto.UserDto;
import pl.maciejpajak.entity.User;

public interface UserService {

    public User findUserByEmail(String email);
    public User registerNewUser(UserDto dto);
    public boolean exists(UserDto dto);
    public List<User> findAll();
    
}
