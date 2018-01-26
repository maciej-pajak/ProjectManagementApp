package pl.maciejpajak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/panel")
    public String showAdminPanel() {
        return "admin/panel";
    }
    
}
