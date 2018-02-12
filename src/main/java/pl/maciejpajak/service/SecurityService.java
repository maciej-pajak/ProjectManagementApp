package pl.maciejpajak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.util.CurrentUser;

@Service
public class SecurityService {

    @Autowired
    private ProjectRepository projectRepo;

    public boolean isProjectOwner(Long projectId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Project p = projectRepo.findOne(projectId);
        if (p == null) {
            return false;
        }
        System.out.println(p);
        System.out.println(p.getDescription());
        System.out.println(p.getOwner());
        return (p.getOwner()
                .getId()
                .equals((
                        (CurrentUser) auth
                        .getPrincipal())
                        .getId()));
    }
}
