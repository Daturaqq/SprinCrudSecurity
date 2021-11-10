package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    List<Role> getAllRoles();

    void saveRole(Role role);

    User addRoleForUser(User user);
}
