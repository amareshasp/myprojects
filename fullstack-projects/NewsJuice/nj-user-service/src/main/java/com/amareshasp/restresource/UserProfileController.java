package com.amareshasp.restresource;

import com.amareshasp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    private static Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody User user) {
        logger.info("Saving user data " + user);
        return "Saved";

    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<User> getUser() {
        logger.info("Fetching user data");
        User user = new User("Amaresh", 37, "gmail");
        return ResponseEntity.ok(user);

    }


}
