package br.com.luisFernando.restapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisFernando.restapi.model.User;
import br.com.luisFernando.restapi.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		userRepository.createUser(user);
		return user;
	}

	@GetMapping("/users")
	public List<User> index() {
		return userRepository.getUsers();
	}

	@GetMapping("/users/{id}")
	public User show(@PathVariable("id") Long id) throws Exception {
		for (User user : userRepository.getUsers()) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new Exception("User not found");
	}

	@PatchMapping("/users/{id}")
	public User update(@PathVariable("id") Long id, @RequestBody Map<String, String> changes) throws Exception {
		User currentUser = userRepository.getUser(id);
		if(changes.containsKey("nome")) {
			currentUser.setNome(changes.get("nome"));	
		}
		if(changes.containsKey("age")) {
			Integer age = Integer.parseInt(changes.get("age"));
			currentUser.setAge(age);	
		}

		
		return currentUser;
	}

	@DeleteMapping("/users/{id}")
	public User delete(@PathVariable("id") Long id) throws Exception {
		User user = userRepository.getUser(id);
		userRepository.removeUser(user);
		return user;
	}

}

// http POST localhost:8080/users id=9 nome=Luis age=25
