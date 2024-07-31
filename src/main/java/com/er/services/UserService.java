package com.er.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.er.models.Account;
import com.er.models.User;
import com.er.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		this.userRepository.save(user);
	}

	public Set<Account> getUserAccounts(String email){
		User resultUser = this.userRepository.findByEmail(email);
		return resultUser.getAccounts();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User resultUser = this.userRepository.findByUsername(username);
		if (resultUser != null) {
			return resultUser;
		}
		throw new UsernameNotFoundException("User " + username + " was not found.");
	}

}
