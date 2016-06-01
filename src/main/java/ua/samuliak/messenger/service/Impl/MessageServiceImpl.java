package ua.samuliak.messenger.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.repository.MessageRepository;
import ua.samuliak.messenger.service.MessageService;

import java.util.List;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public Message getById(long id) {
        return messageRepository.findOne(id);
    }

    public Message save(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    public void remove(long id) {
        messageRepository.delete(id);
    }

    public List<Message> findMessagesByRoomId(@Param("idRoom") long idRoom) {
        return messageRepository.findMessagesByRoomId(idRoom);
    }
}
