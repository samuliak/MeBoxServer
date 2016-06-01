package ua.samuliak.messenger.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.samuliak.messenger.entity.User;
import ua.samuliak.messenger.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUSer();
    }

    @RequestMapping(value = "/user/get/id{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") long userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/user/get/name{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(@PathVariable("name") String userLogin){
        return userService.getByLogin(userLogin);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeUser(@PathVariable("id") long userId){
        userService.removeUser(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }
}