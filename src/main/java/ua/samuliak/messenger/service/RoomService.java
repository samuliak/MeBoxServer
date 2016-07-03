package ua.samuliak.messenger.service;

import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getSortedRooms();
    List<Room> getPartRooms(int a, int b);
    long getCountRooms();
    Room getById(int id);
    Room save(Room room);
    void remove(int id);

    List<Message> getAllMessagesByRoomName(String name);
    Room getByName(String name);
}
