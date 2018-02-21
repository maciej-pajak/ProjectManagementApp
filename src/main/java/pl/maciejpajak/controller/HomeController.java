package pl.maciejpajak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.maciejpajak.service.ActivityService;

@Controller
public class HomeController {

    @Autowired
    private ActivityService serv;
    
    @RequestMapping("/")
    public String home(Model model) {
         model.addAttribute("activities", serv.getRecentActivity());
        return "home";
    }
        
}
