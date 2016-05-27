package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.samuliak.messenger.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
