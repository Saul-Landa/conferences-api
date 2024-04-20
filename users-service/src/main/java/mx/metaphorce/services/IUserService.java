package mx.metaphorce.services;

import mx.metaphorce.entity.User;

public interface IUserService {
    User findById(Long id);
    User save(User user);
    User update(User user);
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
