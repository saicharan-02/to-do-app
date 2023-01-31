package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Credentials;
import com.customer.repository.CredentialsRepository;

@Service
public class CredentialsServiceImpl implements CredentialsService{

	@Autowired
	private CredentialsRepository credRepo;
	
	@Override
	public Credentials login(String userName, String password) throws Exception {

		List<Credentials> optCredentials = credRepo.findByUserName(userName);
		
		return optCredentials.get(0);
	}

}
