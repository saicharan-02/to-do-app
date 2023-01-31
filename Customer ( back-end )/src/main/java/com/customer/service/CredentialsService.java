package com.customer.service;

import com.customer.entity.Credentials;

public interface CredentialsService {
	public Credentials login(String username, String password) throws Exception;
}
