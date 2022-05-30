package in.stackroute.authservice.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.authservice.domain.User;
import in.stackroute.authservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<User> postCreateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));

    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @GetMapping({"/{username}"})
    public ResponseEntity<User> getUserByUserName(@PathVariable String username) {
        Optional<User> user = userService.getUserByUserName(username);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
