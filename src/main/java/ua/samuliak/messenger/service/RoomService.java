package ua.samuliak.messenger.service;

import ua.samuliak.messenger.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getById(long id);
    Room save(Room room);
    void remove(long id);
}
