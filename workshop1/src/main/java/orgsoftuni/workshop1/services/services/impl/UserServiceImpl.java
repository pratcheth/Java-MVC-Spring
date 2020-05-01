package orgsoftuni.workshop1.services.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orgsoftuni.workshop1.data.models.User;
import orgsoftuni.workshop1.data.repositories.UserRepository;
import orgsoftuni.workshop1.services.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUsernameExist(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void save(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> getUserByPassword(String password) {
        return this.userRepository.findByPassword(password);
    }

    @Override
    public Optional<User> findByName(String name) {
        return this.userRepository.findByUsername(name);
    }


}
