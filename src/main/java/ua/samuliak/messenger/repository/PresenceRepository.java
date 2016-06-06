package ua.samuliak.messenger.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.samuliak.messenger.entity.Presence;

import java.util.List;

public interface PresenceRepository extends CrudRepository<Presence, Integer> {

    @Query("select p from Presence p where room_id = ?1")
    List<Presence> findAllByRoomID(Integer roomID);

}