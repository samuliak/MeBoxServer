package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.samuliak.messenger.entity.Room;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    Room findByName(String name);

    @Query("FROM Room ORDER BY creationDate DESC ")
    List<Room> getSortedRooms();
}