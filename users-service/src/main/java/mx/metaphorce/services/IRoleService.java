package mx.metaphorce.services;

import mx.metaphorce.entity.Role;

public interface IRoleService {
    Role findByName(String name);
    Role save(Role role);
}
