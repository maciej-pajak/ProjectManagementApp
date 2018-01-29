package pl.maciejpajak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.service.IProjectService;

@Controller
public class HomeController {
    
    @Autowired
    private IProjectService service;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("createdProjects", service.getProjectsByOwnerId(1L)); // TODO change id to currently logged in user
        model.addAttribute("participateProjects", service.getProjectsByUsersId(1L)); // TODO as above
        // model.addAttribute("activity", service.getActivity..) TODO add activity 
        return "home";
    }
    
}
