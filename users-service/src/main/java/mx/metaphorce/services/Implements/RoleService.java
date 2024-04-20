package mx.metaphorce.services.Implements;

import mx.metaphorce.entity.Role;
import mx.metaphorce.repositories.RoleRepository;
import mx.metaphorce.services.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
