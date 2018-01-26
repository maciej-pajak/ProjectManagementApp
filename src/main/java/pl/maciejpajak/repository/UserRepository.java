package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
