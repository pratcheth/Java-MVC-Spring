package orgsoftuni.workshop1.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/profile")
    public String getUserProfile() {
        return "users/profile.html";
    }
}
