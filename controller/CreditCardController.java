package br.com.luisFernando.restapi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisFernando.restapi.repository.CreditCardRepository;
import br.com.luisFernando.restapi.repository.UserRepository;
import br.com.luisFernando.restapi.exception.UserNotFoundException;
import br.com.luisFernando.restapi.model.CreditCard;
import br.com.luisFernando.restapi.model.User;

@RestController
public class CreditCardController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@GetMapping("/users/{userId}/creditCards")
	public List<CreditCard> index(@PathVariable("userId") Long userId, HttpServletResponse response) throws IOException  {		
		try {
			User user = userRepository.getUser(userId);
			return user.getCreditCards();			
		} catch (UserNotFoundException e){
			response.sendError(404, e.getMessage());
			return null;
		}	
	}
	
	@GetMapping("/users/{userId}/creditCards/{cardId}")
	public CreditCard show(@PathVariable("userId") Long userId, @PathVariable("cardId") Long cardId) throws Exception{		
		return creditCardRepository.getCreditCard(userId, cardId); 
	}
	

}
