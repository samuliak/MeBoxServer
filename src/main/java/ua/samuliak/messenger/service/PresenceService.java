package ua.samuliak.messenger.service;


import ua.samuliak.messenger.entity.Presence;
import ua.samuliak.messenger.entity.Room;

import java.util.List;

public interface PresenceService {
    List<Presence> getAllPresence();
    Room getById(int id);
    Room save(Room room);
    void remove(int id);

    List<Presence> findAllByRoomId(int id);
}
