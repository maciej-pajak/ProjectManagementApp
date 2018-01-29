package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.dto.ProjectDto;
import pl.maciejpajak.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private IProjectService service;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new ProjectDto());
        model.addAttribute("users", service.getAvailableUsers());
        return "forms/createProject";
    }
    
    @PostMapping("/create")
    public String processProjectCreateRequest(@Valid @ModelAttribute("project") ProjectDto project, BindingResult result) {
        if (result.hasErrors()) {
            
            return "forms/createProject";
        }
        service.createProject(project, 1L); // TODO change id
        return "redirect:/";
    }
    
    @RequestMapping("/{id}")
    public String showProjectDetails(@PathVariable Long id, Model model) {
        model.addAttribute("project", service.getProjectByIdFetchUsers(id)); // TODO check for null
        model.addAttribute("tasks", service.getTasksByProjectId(id));
        return "project/showDetails";
    }
}
