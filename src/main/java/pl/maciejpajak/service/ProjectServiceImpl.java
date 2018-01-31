package pl.maciejpajak.service;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Pair;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.repository.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectRepository projectRepo;
    
    @Autowired
    private UserRepository userRepo;
    
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
        return projectRepo.findOneByIdFetchUsers(id);
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

    @Override
    public Map<Long, String> findActiveNamesAndIdsByOwnerAndActive(Long id) {
//        List<Object[]> list = projectRepo.findActiveNamesAndIdsByOwnerAndActive(email);
//        Map<Long, String> test = new HashMap<>();
//        for (Object[] o : list) {
//            test.put((Long) o[0], (String) o[1]);
//        }
//        new Pair<>(fda, fs);
        List<Entry<Long, String>> list = projectRepo.findActiveNamesAndIdsByOwnerAndActive(id);
        Map<Long, String> test = list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        test.forEach((k,v) -> System.out.println("@@@@@@@@@@@@@" + k + "   " + v));
        return test;
    }

}
