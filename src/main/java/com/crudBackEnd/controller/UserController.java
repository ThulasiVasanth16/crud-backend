package com.crudBackEnd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudBackEnd.model.User;
import com.crudBackEnd.repository.UserRepository;



@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "${frontend.url}")

public class UserController {


	
	private final UserRepository repo;

	public UserController(UserRepository repo) {
		this.repo = repo;
	}

	// CREATE
	@PostMapping
	// without requestbody data will not come
	public User addUser(@RequestBody User user) {
		return repo.save(user);
	}

	// READ - all users
	@GetMapping
	public List<User> getAllUsers() {
		return repo.findAll();

	}

	// READ- by id
	@GetMapping("/{id}")
	// @PathVariable is used to get a value from the URL and store it in a Java
	// variable.
	public User getUser(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}

	
	
	//UPDATE
	@PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        User existingUser = repo.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail()); 
            existingUser.setAge(user.getAge());
            return repo.save(existingUser);
        }

        return null;
    }
	
	//DELETE
	  @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        repo.deleteById(id);
	    }
}
