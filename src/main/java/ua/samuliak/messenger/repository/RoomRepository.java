package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.samuliak.messenger.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {}
