package pl.maciejpajak.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.Task;

public interface TaskService {

    public Task createTask(Task task);
    public Page<Task> getTasksByUserId(Long id, Pageable pageable);
    public Task getTaskbyId(Long id);
    public Task updateTaskStatus(Long id, Long statusId);
    public Page<Task> getTasksByProjectId(Long id, Pageable pageable);
    public List<Status> getStatusList();
    public List<Priority> getPrioritiesList();
    
}
