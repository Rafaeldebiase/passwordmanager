package com.rafael.passwordmanager.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	@MessageMapping("/next")
	@SendTo("/topic/next")
	public String broadcastNext(String message) {
		return message;
	}

}
