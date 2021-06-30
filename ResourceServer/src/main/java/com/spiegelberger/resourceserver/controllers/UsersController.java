package com.spiegelberger.resourceserver.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiegelberger.resourceserver.response.UserRest;



@RestController
@RequestMapping("/users")
public class UsersController {

	
	@GetMapping("/status/check")
	public String status() {
		return "UsersController is working.";
	}
		
	//@Secured("ROLE_developer")
	//Access only for those who has the role or the users themselves:
	@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted user with id: " +  id + " and JWT subject: " + jwt.getSubject();
	}
	
	@PostAuthorize("returnObject.userId == #jwt.subject")
	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new UserRest("740249b8-7d63-4a5d-8b22-99d2cd8096aa", "Zsolt", "Spiegelberger");
	}
	
}
