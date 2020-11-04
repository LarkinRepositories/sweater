package com.example.sweater.controller;

import com.example.sweater.model.Message;
import com.example.sweater.model.User;
import com.example.sweater.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    private final MessageService messageService;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageService.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, Map<String, Object> model, @RequestParam(name = "text") String text,
                      @RequestParam(name = "tag") String tag) {
        messageService.addMessage(text, tag, user);
        Iterable<Message> messages = messageService.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("/filter")
    public String filter(@RequestParam(name = "filter") String filterText, Map<String, Object> map) {
        Iterable<Message> filteredMessages = messageService.filterByText(filterText);
        map.put("messages", filteredMessages);
        return "main";
    }

}
