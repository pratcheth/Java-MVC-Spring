package orgsoftuni.workshop1.web.view.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orgsoftuni.workshop1.services.models.auth.LoginUserServiceModel;
import orgsoftuni.workshop1.services.models.heroes.HeroCreateModel;
import orgsoftuni.workshop1.services.services.HeroService;
import orgsoftuni.workshop1.services.services.UserService;
import orgsoftuni.workshop1.web.base.BaseController;
import orgsoftuni.workshop1.web.view.models.HeroRegisterModel;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/heroes")
public class HeroesController extends BaseController {

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
    public String createHero(@ModelAttribute HeroRegisterModel model, HttpSession session) {
        HeroCreateModel createModel = this.modelMapper.map(model, HeroCreateModel.class);
        LoginUserServiceModel user = (LoginUserServiceModel) session.getAttribute("user");
        String username = user.getUsername();

        this.heroService.create(createModel, username);
        return "redirect:/home";
    }
}
