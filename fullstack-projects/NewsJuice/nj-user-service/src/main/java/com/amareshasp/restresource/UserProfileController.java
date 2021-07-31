package com.amareshasp.restresource;

import com.amareshasp.dao.UserRepository;
import com.amareshasp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    private static Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    private final UserRepository userRepository;

    public UserProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody User user) {
        logger.info("Saving user data " + user);
        userRepository.save(user);
        return "Saved";

    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<User> getUser() {
        logger.info("Fetching user data");
       // User user = new User(1,"Amaresh", "gmail",37 );
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.get(0));

    }


}
