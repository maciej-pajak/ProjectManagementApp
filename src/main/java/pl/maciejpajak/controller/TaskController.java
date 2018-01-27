package pl.maciejpajak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.dto.TaskDto;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/create")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new TaskDto());
//        model.addAttribute("", );
        return "forms/createTask";
    }
}
