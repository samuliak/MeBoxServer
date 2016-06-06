package ua.samuliak.messenger.repository;


import org.springframework.data.repository.CrudRepository;
import ua.samuliak.messenger.entity.Room;
public interface RoomRepository extends CrudRepository<Room, Integer> {

    Room findByName(String name);

}