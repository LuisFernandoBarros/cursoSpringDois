package br.com.luisFernando.restapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.luisFernando.restapi.exception.UserNotFoundException;
import br.com.luisFernando.restapi.model.CreditCard;
import br.com.luisFernando.restapi.model.User;
import ch.qos.logback.core.net.SyslogOutputStream;

public class CreditCardRepository {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<CreditCard> getCreditCards(User user){
		List<CreditCard> creditCards = user.getCreditCards();		
		return creditCards;
	}
	
	public CreditCard getCreditCard(Long userId, Long cardId) throws UserNotFoundException {		
			User user = userRepository.getUser(userId);
			System.out.println(userId);
			List<CreditCard> creditCards = user.getCreditCards();
			for(CreditCard creditCard : creditCards ) {
				if(creditCard.getId() == cardId){
					return creditCard;
				}
			}
			throw new UserNotFoundException("Card not found");			
	}

}
