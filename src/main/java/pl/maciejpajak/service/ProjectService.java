package pl.maciejpajak.service;

import java.security.Principal;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
        return projectRepo.findByOwnerIdAndActive(id, true);
    }

    @Override
    public List<Project> getProjectsByUsersId(Long id) {
        return projectRepo.findByUsersIdAndActive(id, true);
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
    public Page<Task> getTasksByProjectId(Long id, Pageable pageable) {
        return taskRepo.findByProjectId(id, pageable);
    }

    @Override
    public Project createProject(Project project, Long id) {
//        org.springframework.security.core.userdetails.User p = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        project.setOwner(userRepo.getOne(id));
        project.setActive(true);
        project.setCreated(LocalDateTime.now());
        project.setIdentifier(generateIdentifier(project.getName()));
        return projectRepo.save(project);
    }

    @Override
    public boolean closeProject(Long id) {
        Project p = projectRepo.findOne(id);
        if (p != null) {
            p.setActive(false);
            projectRepo.save(p);
        }
        return true;
    }

}
