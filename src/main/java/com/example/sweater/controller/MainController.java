package com.example.sweater.controller;

import com.example.sweater.model.Message;
import com.example.sweater.model.User;
import com.example.sweater.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(name="filter", required = false, defaultValue = "")String filter, Model model) {
        Iterable<Message> messages;
        if (filter !=null && !filter.isEmpty()) {
           messages = messageService.filterByText(filter);
        } else {
        messages = messageService.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
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

}
