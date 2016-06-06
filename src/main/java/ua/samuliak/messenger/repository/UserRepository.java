package ua.samuliak.messenger.repository;


import org.springframework.data.repository.CrudRepository;
import ua.samuliak.messenger.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);

}