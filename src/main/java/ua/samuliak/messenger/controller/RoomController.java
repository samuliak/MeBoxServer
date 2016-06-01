package ua.samuliak.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.samuliak.messenger.entity.Message;
import ua.samuliak.messenger.entity.Room;
import ua.samuliak.messenger.service.MessageService;
import ua.samuliak.messenger.service.RoomService;

import java.util.List;
import java.util.Set;

@RestController
public class RoomController {

    // @Autowired - автозаполнение object.
    @Autowired
    private RoomService roomService;

    // <!---- Работа из Room ----!>
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Room getRoom(@PathVariable("id") long roomID){
        return roomService.getById(roomID);
    }

    @RequestMapping(value = "/room/{id}}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRoom(@PathVariable("id") long id){
        roomService.remove(id);
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    @ResponseBody
    public Room saveRoom(@RequestBody Room room){
        return roomService.save(room);
    }

    // @PathVariable - принимаем {id} из HTTP запроса и сохраняем данные в "long id". Потом удаляем по нем.
    // @RequestBody - похожое на @PathVariable, только сохраняет объект, а не примитивный тип данных.
    // @ResponseBody - Аннотация показывает что данный метод может возвращать кастомный объект в виде xml, json...
}
