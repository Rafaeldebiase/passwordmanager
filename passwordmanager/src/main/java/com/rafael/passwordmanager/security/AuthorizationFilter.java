package com.rafael.passwordmanager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.rafael.passwordmanager.services.UserService;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	private TokenFactory tokenFactory;
	private UserService userService;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager, TokenFactory tokenFactory, 
			UserService userService) {
		super(authenticationManager);
		this.tokenFactory = tokenFactory;
		this.userService = userService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		String authorization = request.getHeader("Authorization");
		
		if (authorization != null && authorization.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(request, authorization.substring(7));
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String token) {
		if (tokenFactory.validToken(token)) {
			String userName = tokenFactory.getUserName(token);
			UserDetails user = userService.loadUserByUsername(userName);
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		return null;
	}

	

}
