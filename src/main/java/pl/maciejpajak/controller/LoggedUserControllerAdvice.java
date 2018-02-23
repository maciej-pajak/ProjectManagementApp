package pl.maciejpajak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.service.ProjectService;
import pl.maciejpajak.util.CurrentUser;

@ControllerAdvice(basePackageClasses = {ProjectController.class, RegisterController.class, TaskController.class, HomeController.class})
public class LoggedUserControllerAdvice {

    @Autowired
    private ProjectService service;
    
    @ModelAttribute("createdProjects")
    public Map<Long, String> createdProjects(@AuthenticationPrincipal CurrentUser user) {
        return service.findActiveNamesAndIdsByOwnerAndActive(user.getId());
    }
    
    @ModelAttribute("participateProjects")
    public List<Project> participateProjects(@AuthenticationPrincipal CurrentUser user) {
        return service.getProjectsByUsersId(user.getId());
    }
    
}
