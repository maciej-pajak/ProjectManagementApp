package pl.maciejpajak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.maciejpajak.repository.ProjectRepository;
import pl.maciejpajak.repository.UserRepository;

@Controller
public class HomeController {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private ProjectRepository projectRepo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
}
