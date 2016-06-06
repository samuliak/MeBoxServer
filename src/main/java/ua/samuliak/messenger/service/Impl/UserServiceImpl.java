package ua.samuliak.messenger.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ua.samuliak.messenger.entity.Room;
import ua.samuliak.messenger.entity.User;
import ua.samuliak.messenger.repository.UserRepository;
import ua.samuliak.messenger.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> list = new ArrayList<User>();
        for (User user : userRepository.findAll() ) {
            list.add(user);
        }
        return list;
    }

    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    public void removeUser(int id) {
        userRepository.delete(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getByLogin(@Param("name") String name) {
        return userRepository.findByName(name);
    }

}
