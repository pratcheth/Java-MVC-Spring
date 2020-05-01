package orgsoftuni.workshop1.services;

import orgsoftuni.workshop1.services.models.auth.UserRegisterServiceModel;

public interface AuthValidationService {
    boolean isValid(UserRegisterServiceModel user);
}
