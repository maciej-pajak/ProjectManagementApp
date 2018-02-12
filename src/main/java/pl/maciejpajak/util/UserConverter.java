package pl.maciejpajak.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.UserRepository;

public class UserConverter implements Converter<String, User> {
        
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public User convert(String source) {
        long id = Long.parseLong(source);
        
        return userRepo.findOne(id);
    }

}
