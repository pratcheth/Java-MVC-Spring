package orgsoftuni.workshop1.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orgsoftuni.workshop1.data.models.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {

}
