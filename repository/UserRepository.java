package br.com.luisFernando.restapi.repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.luisFernando.restapi.model.User;

public class UserRepository {
	
	private List<User> users = new ArrayList<>();
	
	public UserRepository () {
		users.add(new User(1L, "Miguel", 25));
		users.add(new User(2L, "Joao", 32));
		users.add(new User(3L, "Arthur", 28));		
	}
	
	public List<User> getUsers(){
		return users;		  
	}
	
	public void createUser(User user) {
		users.add(user);
	}
	
	public User getUser(Long userId) throws Exception {
		for (User user : users) {
			if (user.getId() == userId) {
				return user;
			}
		}
		throw new Exception("User not found");		
	}
	
	public void removeUser(User user) throws Exception {		
		users.remove(user);
	}
	
}
