package orgsoftuni.workshop1.services.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orgsoftuni.workshop1.services.AuthValidationService;
import orgsoftuni.workshop1.services.models.auth.UserRegisterServiceModel;
import orgsoftuni.workshop1.services.services.UserService;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {

    private final UserService userService;

    @Autowired
    public AuthValidationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(UserRegisterServiceModel user) {
        return isUserPasswordValid(user.getPassword(), user.getConfirmPassword())
                && isUserEmailValid(user.getEmail())
                && isUserNameFree(user.getUsername());
    }

    private boolean isUserNameFree(String username) {
        return !this.userService.isUsernameExist(username);
    }

    private boolean isUserEmailValid(String email) {
        return true;
    }

    private boolean isUserPasswordValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
