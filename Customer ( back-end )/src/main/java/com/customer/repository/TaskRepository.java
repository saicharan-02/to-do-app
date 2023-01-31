package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.Credentials;
import com.customer.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{
	@Query(value = "SELECT * FROM task WHERE creds_id = ?1", nativeQuery = true)
	List<Task> viewByUserId(int id);
}
