package orgsoftuni.workshop1.services.services;


import orgsoftuni.workshop1.data.models.User;

import java.util.Optional;

public interface UserService {

    boolean isUsernameExist(String username);

    void save(User user);

    Optional<User> getUserByPassword(String password);
    Optional<User> findByName(String name);
}
