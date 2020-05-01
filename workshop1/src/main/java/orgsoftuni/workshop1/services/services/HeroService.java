package orgsoftuni.workshop1.services.services;

import orgsoftuni.workshop1.data.models.Hero;
import orgsoftuni.workshop1.services.models.heroes.HeroCreateModel;

import javax.servlet.http.HttpSession;

public interface HeroService {
    void save(Hero hero);

    void create(HeroCreateModel createModel, String username);
}
