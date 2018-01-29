package pl.maciejpajak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    public List<Priority> findByActive(boolean active);
    
}
