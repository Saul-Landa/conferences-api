package mx.metaphorce.controllers;

import mx.metaphorce.entity.Gender;
import mx.metaphorce.entity.User;
import mx.metaphorce.services.IGenderService;
import mx.metaphorce.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final IUserService userService;
    private final IGenderService genderService;

    public UserController(IUserService userService, IGenderService genderService) {
        this.userService = userService;
        this.genderService = genderService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/gender")
    public List<Gender> getAllGenders() {
        return genderService.findAll();
    }

}
