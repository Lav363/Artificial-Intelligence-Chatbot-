package com.internship.chatbot.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {
    private final Map<String, String> faqDatabase = new HashMap<>();

    public ChatService() {
        faqDatabase.put("domain", "This AI engine is running a Java-centric Spring architecture configured for immediate scalability.");
        faqDatabase.put("features", "Features include Natural Language normalization, Token-matching routing, asynchronous UI communication, and full MVC isolation.");
        faqDatabase.put("status", "System Status: Online. Operational matrices are running well within limits.");
        faqDatabase.put("help", "You can ask me about project architecture, system status, application features, or basic setup specifications.");
    }

    public String processMessage(String userMessage) {
        if (userMessage == null || userMessage.trim().isEmpty()) return "I didn't catch that. Could you say something?";
        String cleanInput = userMessage.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").trim();
        
        if (cleanInput.matches(".*\\b(hi|hello|hey|greetings)\\b.*")) return "Hello! I am your AI Chatbot assistant. How can I help you with your internship assignment today?";
        if (cleanInput.matches(".*\\b(bye|goodbye|exit)\\b.*")) return "Goodbye! Have a great day ahead and good luck with your submission.";
        
        for (Map.Entry<String, String> entry : faqDatabase.entrySet()) {
            if (cleanInput.contains(entry.getKey())) return entry.getValue();
        }
        return "Interesting query! While my rule-based engine is limited to pre-trained FAQs, my modular backend layer is structured to instantly plug into advanced deep-learning pipelines or Retrieval-Augmented Generation (RAG) vector stores.";
    }
}