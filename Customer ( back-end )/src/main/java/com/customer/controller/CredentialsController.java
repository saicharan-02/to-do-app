package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Credentials;
import com.customer.service.CredentialsServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CredentialsController {
	
	@Autowired
	private CredentialsServiceImpl credService;
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody Credentials cred) throws Exception {
		Credentials creden = credService.login(cred.getUserName(),cred.getPassword());
		
		if(creden.getPassword().equals(cred.getPassword()))
			return new ResponseEntity<>(creden,HttpStatus.OK);
		else
			return new ResponseEntity<>("Invalid Password",HttpStatus.FORBIDDEN);
	}
}
