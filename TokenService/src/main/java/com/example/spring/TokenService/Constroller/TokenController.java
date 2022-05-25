package com.example.spring.TokenService.Constroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring.TokenService.Model.User;

import com.example.spring.TokenService.Repository.TokenRepository;
import com.example.spring.TokenService.Service.KafkaService;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private TokenRepository tRepo;
	
	@Autowired
	public KafkaService kService;
	
	@PostMapping("/createtoken")
	public String create(@RequestBody User user) {
		tRepo.save(user);
		kService.send(user.getDescription());
		return "saved";
	}
	
	
}
