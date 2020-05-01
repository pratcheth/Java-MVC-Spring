package orgsoftuni.workshop1.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import orgsoftuni.workshop1.services.models.auth.LoginUserServiceModel;
import orgsoftuni.workshop1.services.models.auth.UserRegisterServiceModel;
import orgsoftuni.workshop1.services.services.AuthService;
import orgsoftuni.workshop1.web.models.UserRegisterModel;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "auth/register.html";
    }

    @PostMapping("/register")
    private String register(@ModelAttribute UserRegisterModel model) {
        UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(model, UserRegisterServiceModel.class);
        authService.register(userRegisterServiceModel);
        return "redirect:/";
    }

    @PostMapping("/login")
    private String login(@ModelAttribute UserRegisterModel model, HttpSession session) {
        UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(model, UserRegisterServiceModel.class);
        try {
            LoginUserServiceModel loginUserServiceModel = authService.login(userRegisterServiceModel);
            session.setAttribute("user", loginUserServiceModel);
            return "redirect:/home";
        } catch (Exception ex) {
          return "redirect:/users/login";
        }
    }

}
