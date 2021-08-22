package com.amareshasp.restresource;

import com.amareshasp.dao.UserRepository;
import com.amareshasp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserProfileController {
    private static Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    private final UserRepository userRepository;

    private final MongoTemplate mongoTemplate ;

    public UserProfileController(UserRepository userRepository,MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveUser(@RequestBody User user) {
        logger.info("Saving user data " + user);
        userRepository.save(user);
        return "Saved";

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<User> getUser() {
        logger.info("Fetching user data");
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users.get(0));

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-by-mail")
    @ResponseBody
    public ResponseEntity<User> getUserbyEmail(@RequestParam String userEmail) {
        logger.info("Fetching user data by email");

       User user = mongoTemplate.findOne(
                Query.query(Criteria.where("userMail").is(userEmail)), User.class);
        return ResponseEntity.ok(user);

    }



}
