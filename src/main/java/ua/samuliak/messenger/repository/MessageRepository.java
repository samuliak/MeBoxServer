package ua.samuliak.messenger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.samuliak.messenger.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
//    @Query("from Message m where m.id_room = idRoom")
//    List<Message> findMessagesByRoomId(@Param("idRoom") long idRoom);
}
