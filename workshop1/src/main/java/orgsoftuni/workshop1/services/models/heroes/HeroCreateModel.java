package orgsoftuni.workshop1.services.models.heroes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroCreateModel {
    private String name;
    private String gender;
}
