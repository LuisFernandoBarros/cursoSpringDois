package br.com.luisFernando.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.luisFernando.restapi.model.User;
import br.com.luisFernando.restapi.repository.UserRepository;

@RestController
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String indexGet(){
		return "Home Page";
	}

}
