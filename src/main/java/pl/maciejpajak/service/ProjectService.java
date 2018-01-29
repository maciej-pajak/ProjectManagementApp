package pl.maciejpajak.service;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.maciejpajak.dto.ProjectDto;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.repository.TaskRepository;
import pl.maciejpajak.repository.UserRepository;

@Service
public class ProjectService implements IProjectService {
    
    @Autowired
    private ProjectRepository projectRepo;
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TaskRepository taskRepo;
    
    @Override
    public Project createProject(ProjectDto dto, Long ownerId) {
        Project p = new Project();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setIdentifier(generateIdentifier(dto.getName()));
        p.setOwner(userRepo.findOne(ownerId));  // TODO handle null pointer exception
        p.setUsers(dto.getUsers());
        p.setUrl(dto.getUrl());
        p.setCreated(LocalDateTime.now());
        p.setActive(true);
        return projectRepo.save(p);
    }
    
    private String generateIdentifier(String str) {
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        String accentsRemoved = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return accentsRemoved.replaceAll("\\s", "-");
    }

    @Override
    public List<User> getAvailableUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Project> getProjectsByOwnerId(Long id) {
        return projectRepo.findByOwnerId(id);
    }

    @Override
    public List<Project> getProjectsByUsersId(Long id) {
        return projectRepo.findByUsersId(id);
    }
    
    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findOne(id);
    }
    
    @Override
    public Project getProjectByIdFetchUsers(Long id) {
        return projectRepo.findOneByIdFetchUsers(id);
    }

    @Override
    public List<Task> getTasksByProjectId(Long id) {
        return taskRepo.findByProjectId(id);
    }

}
