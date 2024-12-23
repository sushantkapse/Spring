package Kapse1.first.Controllers;


import Kapse1.first.Entity.UserEntity;
import Kapse1.first.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        userService.add(userEntity);
        return userEntity;
    }

    @DeleteMapping
    public void deleteAllUser(){
        userService.deleteMany();
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username,@RequestBody UserEntity userEntity){
        UserEntity userInDb =  userService.findByUsername(username);
        if(userInDb != null){
            userInDb.setUsername(userEntity.getUsername());
            userInDb.setPassword(userEntity.getPassword());
            userService.add(userInDb);
            return  new ResponseEntity<>(userInDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
