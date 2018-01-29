package pl.maciejpajak.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.dto.TaskDto;
import pl.maciejpajak.service.ITaskService;

@Controller
@RequestMapping("/project/{id}/task")
public class TaskController {
    
    @Autowired
    private ITaskService service;

    @GetMapping("/create")
    public String showCreateTaskForm(@PathVariable Long projectId, Model model) {
        TaskDto taskDto = new TaskDto();
        taskDto.setProject(service.getProjectById(projectId));  // TODO null pointer
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("status", service.getStatusList());
        model.addAttribute("priorities", service.getPrioritiesList());
        return "forms/createTask";
    }
    
    @PostMapping("/create")
    public String processTaskCreationRequest(@Valid TaskDto taskDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // TODO refactor this
            model.addAttribute("status", service.getStatusList());
            model.addAttribute("priorities", service.getPrioritiesList());
            return "forms/createTask";
        }
        service.createTask(taskDto);
        return "redirect/project/" + taskDto.getProject().getId();
    }
}
