package orgsoftuni.workshop1.services.services;

import orgsoftuni.workshop1.services.models.auth.LoginUserServiceModel;
import orgsoftuni.workshop1.services.models.auth.UserRegisterServiceModel;

public interface AuthService {
    void register(UserRegisterServiceModel model);

    LoginUserServiceModel login(UserRegisterServiceModel model) throws Exception;

}
