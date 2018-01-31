package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.maciejpajak.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

    public boolean existsByEmail(String email);
    public User findByEmail(String email);
    
}
