package pl.maciejpajak.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.maciejpajak.entity.Role;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.UserRepository;
import pl.maciejpajak.util.CurrentUser;

@Component
@Transactional(readOnly = true)
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : u.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        System.out.println("===================================");
        System.out.println(u);
        System.out.println(u.getEmail());
        System.out.println(u.getId());
        System.out.println("===================================");
        return new CurrentUser(username,
                u.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities,
                u);
    }

}
