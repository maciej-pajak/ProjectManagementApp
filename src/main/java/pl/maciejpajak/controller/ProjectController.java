package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.service.ProjectService;
import pl.maciejpajak.service.TaskService;
import pl.maciejpajak.service.UserService;
import pl.maciejpajak.util.CurrentUser;
import pl.maciejpajak.util.message.Message;
import pl.maciejpajak.util.message.MessageHelper;

@Controller
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("users", userService.findAll());
        return "project/createProject";
    }
    
    @PostMapping("/create")
    public String processProjectCreateRequest(@Valid @ModelAttribute("project") Project project,
            BindingResult result,
            Authentication auth,
            RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "project/createProject";
        }
        project = projectService.createProject(project, ((CurrentUser) auth.getPrincipal()).getId());
        MessageHelper.addSuccessAttribute(ra, "Project " + project.getIdentifier() + " created successfully");
        return "redirect:/";
    }
    
    @RequestMapping("/{id}")
    public String showProjectDetails(@PathVariable Long id, Model model,
            @PageableDefault(size = 5, sort = "priority", direction = Sort.Direction.DESC) 
//            @Qualifier("tasks")
            Pageable pageableTasks,
            @AuthenticationPrincipal CurrentUser user) {
        System.out.println(user.getUsername() + "<=======================@@@@");
        System.out.println(user.getUser() + "<=======================@@@@");
        Project p = projectService.getProjectByIdFetchUsers(id);
        if (!p.getOwner()
                .equals(user.getUser()) && 
                !p.getUsers()
                .contains(
                        user.getUser())) {
            throw new AccessDeniedException("Access denied");
        }
        model.addAttribute("isOwner", p.getOwner().getId().equals(user.getId()));
        model.addAttribute("project", p);
        model.addAttribute("tasks", taskService.getTasksByProjectId(id, pageableTasks));
        return "project/showDetails";
    }
    
    @GetMapping("/{id}/close")
    @PreAuthorize("@securityService.isProjectOwner(#id)")
    public String closeProjectConfirm(@PathVariable Long id) {
        return "project/close";
    }
    
    @PostMapping("/{id}/close")
    @PreAuthorize("@securityService.isProjectOwner(#id)")
    public String closeProject(@PathVariable Long id, @RequestParam boolean close, RedirectAttributes ra) {
        if (close) {
            projectService.closeProject(id);
            MessageHelper.addSuccessAttribute(ra, "project closed");
        }
        return "redirect:/";
    }
}
