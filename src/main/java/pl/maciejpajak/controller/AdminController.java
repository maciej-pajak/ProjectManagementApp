package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.entity.Project;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/panel")
    public String showAdminPanel() {
        return "admin/panel";
    }
    
    // ------------------ projects management ------------------
    @RequestMapping("/projects")
    public String showProjects(Model model) {
        return "admin/projects";
    }
    
    @GetMapping("/project/create")
    public String showCreateProjectForm() {
        return "admin/createProject";
    }
    
    @PostMapping("/project/create")
    public String processProjectCreationRequest(@Valid Project project) {
        return "redirect:/admin/projects";
    }
    
    // ------------------ users management ------------------
    @RequestMapping("/users")
    public String showUsers(Model model) {
        return "admin/users";
    }
    
    @GetMapping("/user/create")
    public String showCreateUserForm() {
        return "admin/createUser";
    }
    
    @PostMapping("/user/create")
    public String processUserCreationRequest(@Valid Project project) {
        return "redirect:/admin/users";
    }
    
    // ------------------ status management ------------------
    @RequestMapping("/status")
    public String showStatus(Model model) {
        return "admin/status";
    }
    
    @GetMapping("/status/create")
    public String showCreateStatusForm() {
        return "admin/createStatus";
    }
    
    @PostMapping("/status/create")
    public String processStatusCreationRequest(@Valid Project project) {
        return "redirect:/admin/status";
    }
    
}
