package pl.maciejpajak.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.User;
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
        return (p.getOwner()
                .getId()
                .equals((
                        (CurrentUser) auth
                        .getPrincipal())
                        .getId()));
    }
    
    @Transactional
    public boolean isProjectOwnerOrUser(Long projectId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long currentUserId = ((CurrentUser) auth.getPrincipal()).getId();
        Project p = projectRepo.findOne(projectId);
        
        if (p == null) {    // check if project is not null
            return false;
        }
        
        if (p.getOwner().getId().equals(currentUserId)) {   // check if is owner
            return true;
        }
        
        for (User u : p.getUsers()) {
            if (u.getId().equals(currentUserId)) {  // check if is user
                return true;
            }
        }

        return false;
    }
}
