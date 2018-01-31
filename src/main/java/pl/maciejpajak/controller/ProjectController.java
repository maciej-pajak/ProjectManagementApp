package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private IProjectService service;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("users", service.getAvailableUsers());
        return "project/createProject";
    }
    
    @PostMapping("/create")
    public String processProjectCreateRequest(@Valid @ModelAttribute("project") Project project, BindingResult result) {
        if (result.hasErrors()) {
            
            return "project/createProject";
        }
        service.createProject(project, 1L);
//        service.createProject(project, 1L); // TODO change id
        return "redirect:/";
    }
    
    @RequestMapping("/{id}")
    public String showProjectDetails(@PathVariable Long id, Model model,
//            @PageableDefault(size = 5, sort = "created", direction = Sort.Direction.DESC) Pageable pageableUsers, // TODO
            @PageableDefault(size = 5, sort = "priority", direction = Sort.Direction.DESC) 
            @Qualifier("tasks")
            Pageable pageableTasks) {
        model.addAttribute("project", service.getProjectByIdFetchUsers(id)); // TODO check for null
        model.addAttribute("tasks", service.getTasksByProjectId(id, pageableTasks));
        return "project/showDetails";
    }
    
    @GetMapping("/{id}/close")
    public String closeProjectConfirm() {
        return "project/close";
    }
    
    @PostMapping("/{id}/close")
    public String closeProject(@PathVariable Long id, @RequestParam boolean close) {
        if (close) {
            service.closeProject(id);
        }
        return "redirect:/";
    }
}
