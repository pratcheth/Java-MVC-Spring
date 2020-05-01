package orgsoftuni.workshop1.services.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import orgsoftuni.workshop1.data.enums.Gender;
import orgsoftuni.workshop1.data.models.Hero;
import orgsoftuni.workshop1.data.repositories.HeroRepository;
import orgsoftuni.workshop1.services.models.heroes.HeroCreateModel;
import orgsoftuni.workshop1.services.services.HeroService;
import orgsoftuni.workshop1.services.services.UserService;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final UserService userService;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper, UserService userService, UserService userService1) {
        this.heroRepository = heroRepository;
        this.userService = userService1;
    }

    @Override
    public void save(Hero hero) {
        this.heroRepository.saveAndFlush(hero);

    }

    @Override
    public void create(HeroCreateModel createModel, String username) {
        Hero hero = new Hero();
        hero.setUsername(createModel.getName());
        hero.setGender(Gender.valueOf(createModel.getGender().toUpperCase()));
        hero.setUser(this.userService.findByName(username).orElse(null));

        this.save(hero);
    }
}
