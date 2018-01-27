package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
    
}
