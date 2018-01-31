package pl.maciejpajak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.service.ProjectService;

@ControllerAdvice(basePackageClasses = {ProjectController.class, RegisterController.class, TaskController.class, HomeController.class})
public class LoggedUserControllerAdvice {

    @Autowired
    private ProjectService service;
    
    @ModelAttribute("createdProjects")
//    public List<Project> createdProjects() {
    public Map<Long, String> createdProjects() {
//        return service.getProjectsByOwnerId(1L); // TODO change id to currently logged in user
        return service.findActiveNamesAndIdsByOwnerAndActive(542L);
    }
    
    @ModelAttribute("participateProjects")
    public List<Project> participateProjects() {
        return service.getProjectsByUsersId(1L); // TODO as above
    }
    
}
