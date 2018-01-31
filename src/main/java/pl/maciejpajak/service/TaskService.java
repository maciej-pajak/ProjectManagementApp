package pl.maciejpajak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.PriorityRepository;
import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.repository.StatusRepository;
import pl.maciejpajak.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepo;
    
    @Autowired
    private StatusRepository statusRepo;
    
    @Autowired
    private PriorityRepository priorityRepo;
    
    @Autowired
    private ProjectRepository projectRepo;
    
    @Override
    public Task createTask(Task task) {
//        Task t = new Task();
//        t.setTopic(dto.getTopic());
//        t.setDescription(dto.getDescription());
//        t.setPriority(dto.getPriority());
//        t.setProject(dto.getProject());
//        t.setStatus(dto.getStatus());
//        t.setUser(dto.getUser());
        return taskRepo.save(task);
    }

    @Override
    public List<Status> getStatusList() {
        return statusRepo.findByActive(true);
    }

    @Override
    public List<Priority> getPrioritiesList() {
        return priorityRepo.findByActive(true);
    }

    @Override
    public List<User> getUsersList() {
        // TODO remove
        return null;
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findOneByIdFetchUsers(id);
    }

    @Override
    public Page<Task> getTasksByUserId(Long id, Pageable pageable) {
        return taskRepo.findByUserId(id, pageable);
    }

    @Override
    public Task getTaskbyId(Long id) {
        return taskRepo.findOne(id);
    }

    @Override
    public Task updateTaskStatus(Long id, Long statusId) {
        Task t = taskRepo.getOne(id);
        t.setStatus(statusRepo.findOne(statusId));;
        return taskRepo.save(t);
    }

}
