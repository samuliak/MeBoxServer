package ua.samuliak.messenger.service;


import org.springframework.data.repository.query.Param;
import ua.samuliak.messenger.entity.User;

import java.util.List;

public interface UserService {
    //Work with User repository
    List<User> getAllUser();
    User getUserById(int id);
    void removeUser(int id);
    void save(User user);
    User getByLogin(@Param("name") String name);
}
