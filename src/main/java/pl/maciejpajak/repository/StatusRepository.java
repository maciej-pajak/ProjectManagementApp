package pl.maciejpajak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{
    
    public List<Status> findByActive(boolean active);
    
}
