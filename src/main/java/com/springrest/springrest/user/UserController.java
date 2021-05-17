package com.springrest.springrest.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

		
		@Autowired  
		private UserRepository userRepository;
		
		@Autowired
		 private UserDynamicqueryclass userdyna;
		
		
		@GetMapping("/jpa/users")  
		public List<User> retriveAllUsers()  
		{  
			List<User> retrive=(List<User>) userRepository.findAll();  
		return retrive;
		} 
			
		
		@GetMapping("/jpa/users/{id}")  
		public Optional<User> retriveUserbyID(@PathVariable int id)  
		{  
			Optional<User> IDUser=userRepository.findById(id);
		if(IDUser==null) { 
			//runtime exception  
			throw new UserNotFoundException("id: "+ id);
		}
		return IDUser; 
		} 
		
		
		@GetMapping("/jpa/users/name/{name}")  
		public List<User> retriveUserbyname(@PathVariable String name)  
		{  
			List<User> NameUser=userRepository.findByName(name);
		if(NameUser==null) { 
			//runtime exception  
			throw new UserNotFoundException("name: "+ name);
		}
		return NameUser; 
		} 
		
		
		@GetMapping("/jpa/users/nameDynamic/{name}")  
		public List<User> retriveUserDynamically(@PathVariable String name)  
		{
			return userdyna.findByCriteria(name);
			
		} 
		
		//method that delete a user resource  
		@DeleteMapping("/jpa/users/{id}")  
		public void deleteUser(@PathVariable int id)  
		{  
				
			userRepository.deleteById(id);			
		}  
		
		//method that posts a new user detail and returns the status of the user resource 
		@PostMapping("/jpa/users")
		public ResponseEntity<Object> createUser(@Valid @RequestBody User user)     
		{  
		User sevedUser=userRepository.save(user);    
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();  
		return ResponseEntity.created(location).build();  
		}  		
		
	}

