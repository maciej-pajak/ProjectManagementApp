package pl.maciejpajak.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public Page<Task> findByProjectId(Long id, Pageable pageable);
    public Page<Task> findByUserId(Long id, Pageable pageable);
    
}
