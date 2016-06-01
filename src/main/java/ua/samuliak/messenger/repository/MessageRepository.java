package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.samuliak.messenger.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("from Message m where m.id_room like %:idRoom%")
    List<Message> findMessagesByRoomId(@Param("idRoom") long idRoom);
}
