package com.er.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.er.models.User;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	public User findByEmail(String email);
	public User findByUsername(String username);
}
