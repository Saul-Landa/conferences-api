package mx.metaphorce.utils;

import mx.metaphorce.entity.Gender;
import mx.metaphorce.entity.Role;
import mx.metaphorce.entity.User;
import mx.metaphorce.services.IGenderService;
import mx.metaphorce.services.IRoleService;
import mx.metaphorce.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Transactional
public class InitialData implements CommandLineRunner {

    private final String admin = "ROLE_ADMIN";
    private final String client = "ROLE_CLIENT";
    private final String male = "Male";
    private final List<String> roles = Arrays.asList(admin, client);
    private final List<String> genders = Arrays.asList(male, "Female", "I prefer not to answer");
    private final IRoleService roleService;
    private final IUserService userService;
    private final IGenderService genderService;

    public InitialData(IRoleService roleService, IUserService userService, IGenderService genderService) {
        this.roleService = roleService;
        this.userService = userService;
        this.genderService = genderService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            saveRoles();
            saveGenders();
            saveUsers();
        } catch (Exception exception) {
            System.out.println();
            throw new Exception("Error saving initial data");
        }
    }

    private void saveRoles() {
        roles.forEach( roleItem -> {
            if ( roleService.findByName(roleItem) == null ) {
                Role role = new Role();
                role.setName(roleItem);

                roleService.save(role);
            }
        });
    }

    private void saveGenders() {
        genders.forEach( genderItem -> {
            if ( genderService.findByName(genderItem) == null ) {
                Gender gender = new Gender();
                gender.setName(genderItem);

                genderService.save(gender);
            }
        });
    }

    private void saveUsers() {
        Role clientRole = roleService.findByName(client);
        Role adminRole = roleService.findByName(admin);
        Gender gender = genderService.findByName(male);

        String username = "client";
        if ( userService.findByUsername(username) == null ) {
            User user = new User(
                    username, "SL2024","Saúl", "Landa", "saul.landa@gmail.com",
                    Collections.singletonList(clientRole), gender);

            userService.save(user);
        }

        username = "admin";
        if ( userService.findByUsername(username) == null ) {
            User user = new User(
                    username, "JF2024","Joel", "Flores", "joel.flore@gmail.com",
                    Collections.singletonList(adminRole), gender);

            userService.save(user);
        }
    }

}
