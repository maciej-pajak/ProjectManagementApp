package pl.maciejpajak.service;

import java.util.List;

import pl.maciejpajak.dto.TaskDto;
import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;

public interface ITaskService {

    public Task createTask(TaskDto dto);
    public List<Status> getStatusList();
    public List<Priority> getPrioritiesList();
    public List<User> getUsersList();
    public Project getProjectById(Long id);
    
}
