package ua.samuliak.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.service.MessageService;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    // <!---- Работа из Message ----!>
    @RequestMapping(value = "/rooms/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getAllMessages(){
        return messageService.getAllMessage();
    }

    @RequestMapping(value = "/room/messages/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getRoomMessages(@PathVariable("id") long roomID){
        return messageService.findMessagesByRoomId(roomID);
    }

//    @RequestMapping(value = "/room/{id}}", method = RequestMethod.POST)
//    @ResponseBody
//    public void deleteRoom(@PathVariable("id") long id){
//        roomService.remove(id);
//    }
//
//    @RequestMapping(value = "/room", method = RequestMethod.POST)
//    @ResponseBody
//    public Room saveRoom(@RequestBody Room room){
//        return roomService.save(room);
//    }
}
