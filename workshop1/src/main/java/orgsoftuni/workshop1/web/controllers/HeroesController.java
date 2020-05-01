package orgsoftuni.workshop1.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orgsoftuni.workshop1.services.models.auth.LoginUserServiceModel;
import orgsoftuni.workshop1.services.models.heroes.HeroCreateModel;
import orgsoftuni.workshop1.services.services.HeroService;
import orgsoftuni.workshop1.services.services.UserService;
import orgsoftuni.workshop1.web.models.HeroRegisterModel;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    private final ModelMapper modelMapper;
    private final HeroService heroService;
    private final UserService userService;

    public HeroesController(ModelMapper modelMapper, HeroService heroService, UserService userService) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getCreateForm() {
        return "heroes/create-hero.html";
    }

    @GetMapping("/details/{name}")
    public String getHeroDetails(@PathVariable String name) {
        return "heroes/heroDetails.html";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute HeroRegisterModel model, HttpSession session) {
        HeroCreateModel createModel = this.modelMapper.map(model, HeroCreateModel.class);

        Object sessionModel = session.getAttribute("user");
        String username = "";

        if (sessionModel instanceof LoginUserServiceModel) {
            username = ((LoginUserServiceModel)sessionModel).getUsername();
        }
        this.heroService.create(createModel, username);
        return "redirect:/home";
    }
}
