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

    //////////////   Отримати всіх юзерів
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //////////////   Отримати юзера по ІД
    @RequestMapping(value = "/user/id{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") int userId){
        return userService.getUserById(userId);
    }

    //////////////   Отримати юзера по імені
    @RequestMapping(value = "/user/name{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(@PathVariable("name") String userLogin){
        return userService.getByLogin(userLogin);
    }

    /////////////////   Видалити юзера
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeUser(@PathVariable("id") int userId){
        userService.removeUser(userId);
    }

    //////////////////   Зберегти юзера
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }
}