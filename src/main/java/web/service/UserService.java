package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserByUsername(String username);

    List<User> getAllUsers();

    void save(User user);

    void saveOrUpdate(User user);

    User getUserById(long id);

    void delete(long id);
}
