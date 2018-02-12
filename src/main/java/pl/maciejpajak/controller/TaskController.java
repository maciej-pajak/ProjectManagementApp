package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.service.ProjectService;
import pl.maciejpajak.service.TaskService;
import pl.maciejpajak.util.CurrentUser;

@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/{id}/task/create")
    @PreAuthorize("@securityService.isProjectOwner(#id)") // TODO or is admin
    public String showCreateTaskForm(@PathVariable Long id, Model model) {
        
        taskFormAddModelAttributes(model, id);
        model.addAttribute("task", new Task());
        
        return "task/createTask";
    }
    
    @PostMapping("/project/{id}/task/create")
    @PreAuthorize("@securityService.isProjectOwner(#id)")
    public String processTaskCreationRequest(@Valid Task task, BindingResult result,
                                            @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            taskFormAddModelAttributes(model, id);
            return "task/createTask";
        }
        Project p = new Project();
        p.setId(id);
        task.setProject(p);
        taskService.createTask(task);
        return "redirect:/project/" + id;
    }
    
    private void taskFormAddModelAttributes(Model model, Long projectId) {
        Project p = projectService.getProjectByIdFetchUsers(projectId);
        model.addAttribute("project", p);
        model.addAttribute("status", taskService.getStatusList());
        model.addAttribute("priorities", taskService.getPrioritiesList());
    }
    
    @RequestMapping("/tasks")
    public String showUsersTasks(@PageableDefault(size = 5, sort = "priority", direction = Sort.Direction.DESC) Pageable pageable,
            Model model,
            Authentication authentication) {
        Long id = ((CurrentUser) authentication.getPrincipal()).getId();
        model.addAttribute("tasks", taskService.getTasksByUserId(id, pageable));
        return "task/showUserTasks";
    }
    
    @GetMapping("/task/{id}")
    public String showTaskDetails(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskbyId(id));
        model.addAttribute("status", taskService.getStatusList());
        return "task/showDetails";
    }
    
    @PostMapping("/task/{id}")
//    @PreAuthorize("@securityService.isProjectOwner(#id)")
    public String processUpdateStatusRequest(@PathVariable Long id, @RequestParam Long status) {
        taskService.updateTaskStatus(id, status);
        return "redirect:/tasks";
    }
//    @GetMapping("/status/{id}/edit")
//    public String showStatusEditForm(Model model) {
//        model.addAttribute("status", service.getStatusList());
//        return "task/changeStatus";
//    }
}
