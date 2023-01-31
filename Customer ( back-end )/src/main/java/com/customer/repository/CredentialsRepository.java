package com.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.Credentials;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Integer>{
	
	@Query(value = "SELECT * FROM credentials WHERE user_name = ?1", nativeQuery = true)
	List<Credentials> findByUserName(String userName);
	
}
