package pl.maciejpajak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.maciejpajak.dto.UserDto;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.UserRepository;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public User registerNewUser(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPassword(dto.getPassword());    // TODO encode password here
        return userRepo.save(user);
    }

    @Override
    public boolean exists(UserDto dto) {
        return userRepo.existsByEmail(dto.getEmail());
    }
    
    

}
