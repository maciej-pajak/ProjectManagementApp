package pl.maciejpajak.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.maciejpajak.dto.UserDto;
import pl.maciejpajak.entity.Role;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.RoleRepository;
import pl.maciejpajak.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerNewUser(UserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        
        Role userRole = roleRepo.findByRoleName("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        return userRepo.save(user);
    }

    @Override
    public boolean exists(UserDto dto) {
        return userRepo.existsByEmail(dto.getEmail());
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
    

}
