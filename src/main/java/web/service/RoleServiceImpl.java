package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao DAO;

    public RoleServiceImpl(RoleDao DAO) {
        this.DAO = DAO;
    }

    @Override
    public Role getRoleByName(String name) {
        return DAO.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return DAO.getAllRoles();
    }

    @Override
    public void saveRole(Role role) {
        DAO.saveRole(role);
    }

    @Override
    public User addRoleForUser(User user) {
        Set<Role> roleSet = new HashSet<>();
        Role adminRole = getRoleByName("ROLE_ADMIN");
        Role userRole = getRoleByName("ROLE_USER");
        for (Role role : user.getRoles()) {
            if (role.getName().equals(adminRole.getName())) {
                roleSet.add(adminRole);
            } else if (role.getName().equals(userRole.getName())) {
                roleSet.add(userRole);
            }
        }
        user.setRoles(roleSet);
        return user;
    }
}
