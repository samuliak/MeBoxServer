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
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getAllMessages(){
        return messageService.getAllMessage();
    }

//    @RequestMapping(value = "/room/messages/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Message> getRoomMessages(@PathVariable("id") long roomID){
//        return messageService.findMessagesByRoomId(roomID);
//    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void getMessageById(@PathVariable("id") long id){
        messageService.getById(id);
    }

    @RequestMapping(value = "/message/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRoom(@PathVariable("id") long id){
        messageService.remove(id);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public Message saveRoom(@RequestBody Message message){
        return messageService.save(message);
    }
}
