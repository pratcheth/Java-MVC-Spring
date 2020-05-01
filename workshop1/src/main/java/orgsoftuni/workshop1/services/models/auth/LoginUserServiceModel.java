package orgsoftuni.workshop1.services.models.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserServiceModel {
    private String username;
    private String heroName;

    public LoginUserServiceModel(String username, String heroName) {
        this.username = username;
        this.heroName = heroName;
    }
}
