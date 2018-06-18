package br.com.luisFernando.restapi.repository;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.luisFernando.restapi.exception.UserNotFoundException;
import br.com.luisFernando.restapi.model.CreditCard;
import br.com.luisFernando.restapi.model.User;

public class UserRepository {
	
	private List<User> users = new ArrayList<>();
	
	public UserRepository () {
		User miguel = new User(1L, "Miguel", 25);
		miguel.addCreditCard(new CreditCard(1L, "2001.3521.5414.9784"));
		
		
		users.add(miguel);
		users.add(new User(2L, "Joao", 32));
		users.add(new User(3L, "Arthur", 28));		
	}
	
	public List<User> getUsers(){
		return users;		  
	}
	
	public void createUser(User user) {
		users.add(user);
	}
	
	public User getUser(Long userId) throws UserNotFoundException {
		for (User user : users) {
			if (user.getId() == userId) {
				return user;
			}
		}
		throw new UserNotFoundException("User not found");		
	}
	
	public void removeUser(User user) throws UserPrincipalNotFoundException {		
		users.remove(user);
	}
	
}
