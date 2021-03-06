package com.dev.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.dev.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,
			              @RequestParam(value="limit", defaultValue="50") int limit,
			              @RequestParam(value="sort", defaultValue="desc", required = false) String sort) {
		
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}
	
	@GetMapping(path="/{userId}", 
			    produces = { MediaType.APPLICATION_XML_VALUE, 
			                 MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		//use ResponseEntity response status code
		UserRest returnValue = new UserRest();
		
		returnValue.setEmail("test@test.com");
		returnValue.setFirstName("pattana");
		returnValue.setLastName("chaiyata");
		//คืนค่าให้ออปเจ็ค UserRest จากค่าใน returnValue ถ้าถูกต้องให้แสดง code
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, 
			                 MediaType.APPLICATION_JSON_VALUE })
	public String createUser(@RequestBody UserDetailsRequestModel userDetail) {
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
