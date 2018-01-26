package pl.maciejpajak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
