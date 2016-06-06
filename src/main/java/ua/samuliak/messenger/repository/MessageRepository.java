package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.samuliak.messenger.entity.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    @Query("select m from Message m where room_id = ?1")
    List<Message> findAllByRoomID(Integer roomID);

}