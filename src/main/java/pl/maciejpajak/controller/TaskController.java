package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.maciejpajak.entity.Task;
import pl.maciejpajak.service.ProjectService;
import pl.maciejpajak.service.TaskService;

@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/{id}/task/create")
    @PreAuthorize("projectService.getProjectById(id).owner.id==1")
    public String showCreateTaskForm(@PathVariable Long id, Model model) {
        Task task = new Task();
        task.setProject(projectService.getProjectById(id));  // TODO null pointer
        model.addAttribute("taskDto", task);
        model.addAttribute("status", taskService.getStatusList());
        model.addAttribute("priorities", taskService.getPrioritiesList());
        return "task/createTask";
    }
    
    @PostMapping("/project/{id}/task/create")
    public String processTaskCreationRequest(@Valid Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // TODO refactor this --- project null
            model.addAttribute("status", taskService.getStatusList());
            model.addAttribute("priorities", taskService.getPrioritiesList());
            return "task/createTask";
        }
        taskService.createTask(task);
        return "redirect:/project/" + task.getProject().getId();
    }
    
    @RequestMapping("/tasks")
    public String showUsersTasks(@PageableDefault(size = 5, sort = "priority", direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {
        model.addAttribute("tasks", taskService.getTasksByUserId(1L, pageable)); // TODO change id to current user
        return "task/showUserTasks";
    }
    
    @GetMapping("/task/{id}")
    public String showTaskDetails(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskbyId(id));
        model.addAttribute("status", taskService.getStatusList());
        return "task/showDetails";
    }
    
    @PostMapping("/task/{id}")
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
