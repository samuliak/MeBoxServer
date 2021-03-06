package ua.samuliak.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.entity.Presence;
import ua.samuliak.messenger.entity.Room;
import ua.samuliak.messenger.repository.MessageRepository;
import ua.samuliak.messenger.repository.PresenceRepository;
import ua.samuliak.messenger.service.RoomService;
import ua.samuliak.messenger.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private PresenceRepository presenceRepository;

    // <!---- Работа из Room ----!>

    ///////////// Отримати всі кімнати
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> getSortedRooms(){
        return roomService.getSortedRooms();
    }

    ///////////// Отримати кімнати між діапазону
    @RequestMapping(value = "/rooms/from{a}/to{b}", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> getPartRooms(@PathVariable("a") int a, @PathVariable("b") int b){
        return roomService.getPartRooms(a, b);
    }

    ///////////// Отримати кількість кімнат
    @RequestMapping(value = "/rooms/count", method = RequestMethod.GET)
    @ResponseBody
    public long getCountRooms(){
        return roomService.getCountRooms();
    }

    /////////////   Отримати кімнату по ІД
    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Room getRoom(@PathVariable("id") int roomID){
        return roomService.getById(roomID);
    }

    ///////////////   Видалити кімнату
    @RequestMapping(value = "/room/{id}}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRoom(@PathVariable("id") int id){
        roomService.remove(id);
    }

    //////////////   Зберегти кімнату
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    @ResponseBody
    public Room saveRoom(@RequestBody Room room){
        return roomService.save(room);
    }

    //////////////   Отримати всіх юзерів, які знаходяться у кімнаті
    @RequestMapping(value = "/room/presence/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Presence> getAllPresenceInRoomByName(@PathVariable("name")String name) {
        List<Presence> list = new ArrayList<Presence>();
        for ( Presence presence : presenceRepository.findAllByRoomID(roomService.getByName(name).getRoomID()) ) {
            list.add(presence);
        }
        return list;
    }

    /////////////////  Відправити смс в кімнату.
    @RequestMapping(value = "/room/message/", method = RequestMethod.POST)
    @ResponseBody
    public void sendMessageInRoom(@RequestBody Message message) {
        messageRepository.save(message);
    }

    //////////////   Отримати всі смс по кімнаті
    @RequestMapping(value = "/room/messages/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getAllMessageByRoomId(@PathVariable("name") String name) {
        List<Message> list = new ArrayList<Message>();
        for (Message message : messageRepository.findAllByRoomID(roomService.getByName(name).getRoomID()) ) {
            list.add(message);
        }
        return list;
    }


}
