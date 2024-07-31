package com.er.repositories;

import org.springframework.data.repository.CrudRepository;

import com.er.models.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, String> {
	
	public User findByEmail(String email);
	public User findByUsername(String username);
}
