package orgsoftuni.workshop1.services.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orgsoftuni.workshop1.data.models.User;
import orgsoftuni.workshop1.services.AuthValidationService;
import orgsoftuni.workshop1.services.models.auth.LoginUserServiceModel;
import orgsoftuni.workshop1.services.models.auth.UserRegisterServiceModel;
import orgsoftuni.workshop1.services.services.AuthService;
import orgsoftuni.workshop1.services.services.HashingService;
import orgsoftuni.workshop1.services.services.UserService;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final AuthValidationService authValidationService;
    private final UserService userService;
    private final HashingService hashingService;

    @Autowired
    public AuthServiceImpl(ModelMapper modelMapper, AuthValidationService authValidationService, UserService userService, HashingService hashingService) {
        this.modelMapper = modelMapper;
        this.authValidationService = authValidationService;
        this.userService = userService;
        this.hashingService = hashingService;
    }

    @Override
    public void register(UserRegisterServiceModel model) {

        if (!this.authValidationService.isValid(model)) {
            //do
            return;
        }

        User user = this.modelMapper.map(model, User.class);
        user.setPassword(this.hashingService.hashPass(user.getUsername(), user.getPassword()));
        this.userService.save(user);
    }

    @Override
    public LoginUserServiceModel login(UserRegisterServiceModel model) throws Exception {
        String shaPass = this.hashingService.hashPass(model.getUsername(), model.getPassword());
        Optional<User> userOptional = this.userService.getUserByPassword(shaPass);
        if(userOptional.isEmpty()){
            throw new Exception("Invalid User!");
        } else {
            User user = userOptional.get();
            String heroName = user.getHero() == null ? null : user.getHero().getUsername();
            return new LoginUserServiceModel(user.getUsername(), heroName);
        }
    }
}
