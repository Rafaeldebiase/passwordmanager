package com.rafael.passwordmanager.handler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.rafael.passwordmanager.Domain.StompPrincipal;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {
	
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
    
        return new StompPrincipal(UUID.randomUUID().toString());
    }

}
