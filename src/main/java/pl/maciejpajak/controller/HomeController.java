package pl.maciejpajak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {

        // model.addAttribute("activity", service.getActivity..) TODO add activity 
        return "home";
    }
    
    
}
