package ua.samuliak.messenger.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.entity.Room;
import ua.samuliak.messenger.repository.MessageRepository;
import ua.samuliak.messenger.repository.RoomRepository;
import ua.samuliak.messenger.service.RoomService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Room> getSortedRooms() {
          return roomRepository.getSortedRooms();
    }

    public List<Room> getPartRooms(int a, int b) {
        List<Room> list = roomRepository.getSortedRooms();
        a--; b--;
        List<Room> partList = new ArrayList<Room>();
        for(int i=0; i<list.size(); i++){
            if(i >= a && i < b)
                partList.add(list.get(i));
        }
        return partList;
    }

    public long getCountRooms() {
        return roomRepository.getSortedRooms().size();
    }

    public Room getById(int id) {
        return roomRepository.findOne(id);
    }

    public Room getByName(String name) {
        return roomRepository.findByName(name);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void remove(int id) {
        roomRepository.delete(id);
    }

    public List<Message> getAllMessagesByRoomName(String name) {
        List<Message> list = new ArrayList<Message>();
        for ( Message message : messageRepository.findAllByRoomID(roomRepository.findByName(name).getRoomID()) ) {
            list.add(message);
        }
        return list;
    }
}
