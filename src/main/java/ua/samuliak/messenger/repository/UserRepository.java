package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.samuliak.messenger.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("FROM User WHERE login = :name ")
    User findByName(@Param("name") String name);
}