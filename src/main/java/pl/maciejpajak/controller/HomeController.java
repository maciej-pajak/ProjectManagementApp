package pl.maciejpajak.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.maciejpajak.entity.Activity;
import pl.maciejpajak.repository.ActivityRepository;
import pl.maciejpajak.service.ActivityService;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
         model.addAttribute("activities", serv.getRecentActivity());
        return "home";
    }
    
    @Autowired
    private ActivityService serv;
    
    
    @Autowired
    private ActivityRepository repo;
    
    @RequestMapping("/test") // TODO remove
    public String test(RedirectAttributes redirectAttributes) {
        Activity a = new Activity();
        a.setCreated(LocalDateTime.now());
        a.setObjectId(4L);
        System.out.println("----------------->" + getClass() + "<----------------");
        a.setObjectClass(pl.maciejpajak.entity.Task.class);
        repo.save(a);
        // ======
        redirectAttributes.addFlashAttribute("message", "test message");
        return "redirect:/";
    }
    
    
}
