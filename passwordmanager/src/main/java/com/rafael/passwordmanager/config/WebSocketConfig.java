package com.rafael.passwordmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.rafael.passwordmanager.handler.CustomHandshakeHandler;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
        	.addEndpoint("/ws")
        	.setAllowedOrigins("*")
        	.setHandshakeHandler(new CustomHandshakeHandler());
		registry
        	.addEndpoint("/ws")
        	.setAllowedOrigins("*")
        	.setHandshakeHandler(new CustomHandshakeHandler())
        	.withSockJS();
	    
	  }  
	
	@Override
	  public void configureMessageBroker(MessageBrokerRegistry config){ 
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	  }
	

}
