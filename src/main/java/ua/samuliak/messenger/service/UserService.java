package ua.samuliak.messenger.service;


import ua.samuliak.messenger.entity.User;

import java.util.List;

public interface UserService {
    //Work with User repository
    List<User> getAllUSer();
    User getUserById(long id);
    void removeUser(long id);
    void save(User user);

}
