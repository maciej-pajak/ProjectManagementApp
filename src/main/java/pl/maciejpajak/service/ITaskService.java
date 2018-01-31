package pl.maciejpajak.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;

import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;

public interface ITaskService {

    public Task createTask(Task task);
    public List<Status> getStatusList();
    public List<Priority> getPrioritiesList();
    public List<User> getUsersList();
    public Project getProjectById(Long id);
    public Page<Task> getTasksByUserId(Long id, Pageable pageable);
    public Task getTaskbyId(Long id);
    public Task updateTaskStatus(Long id, Long statusId);
}
