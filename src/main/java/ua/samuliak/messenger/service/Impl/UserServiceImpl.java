package ua.samuliak.messenger.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.samuliak.messenger.entity.User;
import ua.samuliak.messenger.repository.UserRepository;
import ua.samuliak.messenger.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUSer() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public void removeUser(long id) {
        userRepository.delete(id);
    }

    public void save(User user) {
        userRepository.saveAndFlush(user);
    }
}
