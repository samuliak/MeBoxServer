package ua.samuliak.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messenger")
public class MessengerController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(ModelMap model){
        return "Static message";
    }

}
