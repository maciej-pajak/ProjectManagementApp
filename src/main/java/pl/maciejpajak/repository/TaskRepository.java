package pl.maciejpajak.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.maciejpajak.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByProjectId(Long id);
    public Page<Task> findByUserId(Long id, Pageable pageable);
    
    public Page<Task> findByProjectIdAndActive(Long id, Pageable pageable, boolean active);
    public Page<Task> findByUserIdAndActive(Long id, Pageable pageable, boolean active);
    public Task findOneByIdAndActive(Long id, boolean active);
    
}
