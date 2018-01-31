package pl.maciejpajak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.repository.PriorityRepository;
import pl.maciejpajak.repository.StatusRepository;
import pl.maciejpajak.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;
    
    @Autowired
    private StatusRepository statusRepo;
    
    @Autowired
    private PriorityRepository priorirytRepo;
    
    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
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
        t.setStatus(statusRepo.findOne(statusId));
        return taskRepo.save(t);
    }

    @Override
    public Page<Task> getTasksByProjectId(Long id, Pageable pageable) {
        return taskRepo.findByProjectId(id, pageable);
    }

    @Override
    public List<Status> getStatusList() {
        return statusRepo.findByActive(true);
    }

    @Override
    public List<Priority> getPrioritiesList() {
        return priorirytRepo.findByActive(true);
    }

}
