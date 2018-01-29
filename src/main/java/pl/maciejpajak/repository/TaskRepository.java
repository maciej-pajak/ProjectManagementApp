package pl.maciejpajak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findByProjectId(Long id);
}
