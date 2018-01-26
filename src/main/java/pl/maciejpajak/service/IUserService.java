package pl.maciejpajak.service;

import pl.maciejpajak.dto.UserDto;
import pl.maciejpajak.entity.User;

public interface IUserService {
    
    public User registerNewUser(UserDto dto);
    public boolean exists(UserDto dto);

}
