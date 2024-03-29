package com.app.ws.ui.controller;



import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.catalina.User;
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

import com.app.ws.ui.model.request.UserDetailsRequest;
import com.app.ws.ui.model.responce.UserRest;

@RestController
@RequestMapping("/üsers") //call //http://localhost:8888/üsers
public class UserController {
	
	Map<String, UserRest> userrest;
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",required = false)Integer page,@RequestParam(value="limit",defaultValue = "20")int limit)
	{
		return "get users service called page = "+page+" limit = "+limit;
	}
	
	@GetMapping(path="/{userID}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userID)
	{
		if(userrest.containsKey(userID)) {
			return new ResponseEntity<>(userrest.get(userID), HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest detailsRequest)
	{
		UserRest returnuser=new UserRest();
		returnuser.setFirstname(detailsRequest.getFirstname());
		returnuser.setLastname(detailsRequest.getLastname());
		returnuser.setEmil(detailsRequest.getEmil());
		returnuser.setUserid(detailsRequest.getUserid());
		if(userrest==null) {
			userrest.put("123", returnuser);
		}
		return new ResponseEntity<UserRest>(returnuser, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser()
	{
		return"update user first web service called";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return"delete user first web service called";
	}

}
