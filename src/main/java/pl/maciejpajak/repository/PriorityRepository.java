package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Priority;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
