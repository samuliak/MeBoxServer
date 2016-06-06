package ua.samuliak.messenger.service;

import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getById(int id);
    Room save(Room room);
    void remove(int id);

    List<Message> getAllMessagesByRoomName(String name);
    Room getByName(String name);
}
