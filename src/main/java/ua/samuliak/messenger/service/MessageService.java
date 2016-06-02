package ua.samuliak.messenger.service;


import ua.samuliak.messenger.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();
    Message getById(long id);
    Message save(Message message);
    void remove(long id);
//    List<Message> findMessagesByRoomId(@Param("name") long id_Room);
}
