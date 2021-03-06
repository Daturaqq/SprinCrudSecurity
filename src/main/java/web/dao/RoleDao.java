package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleByName(String name);

    List<Role> getAllRoles();

    void saveRole(Role role);
}
