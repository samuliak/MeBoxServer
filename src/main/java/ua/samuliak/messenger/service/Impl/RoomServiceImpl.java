package ua.samuliak.messenger.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.samuliak.messenger.entity.Room;
import ua.samuliak.messenger.repository.RoomRepository;
import ua.samuliak.messenger.service.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getById(long id) {
        return roomRepository.findOne(id);
    }

    public Room save(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    public void remove(long id) {
        roomRepository.delete(id);
    }
}
