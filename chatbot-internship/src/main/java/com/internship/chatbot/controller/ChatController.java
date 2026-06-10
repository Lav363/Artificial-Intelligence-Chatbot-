package com.internship.chatbot.controller;

import com.internship.chatbot.model.ChatRequest;
import com.internship.chatbot.model.ChatResponse;
import com.internship.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ChatResponse handleChat(@RequestBody ChatRequest request) {
        return new ChatResponse(chatService.processMessage(request.getMessage()));
    }
}