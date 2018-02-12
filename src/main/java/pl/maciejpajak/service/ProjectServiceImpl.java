package pl.maciejpajak.service;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.repository.TaskRepository;
import pl.maciejpajak.repository.UserRepository;
import pl.maciejpajak.util.BaseEntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {
    
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
        return projectRepo.findOneByIdAndActiveFetchUsers(id).orElseThrow(() -> new BaseEntityNotFoundException(id));
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
    public Project closeProject(Long id) {
        Project p = projectRepo.findOne(id);
        if (p != null) {
            p.setActive(false);
            List<Task> tasks = taskRepo.findAllByProjectId(id);
            tasks.forEach(t -> t.setActive(false));
            taskRepo.save(tasks);
            return projectRepo.save(p);
        }
        return null;
    }

    @Override
    public Map<Long, String> findActiveNamesAndIdsByOwnerAndActive(Long id) {
        List<Entry<Long, String>> list = projectRepo.findActiveNamesAndIdsByOwnerAndActive(id);
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    @Override
    public String findProjectIdentifier(Long id) {
        return projectRepo.findProjectIdentifier(id);
    }

}
