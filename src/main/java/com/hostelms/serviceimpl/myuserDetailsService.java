package com.hostelms.serviceimpl;

import java.util.ArrayList;

import com.hostelms.model.User;
import com.hostelms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class myuserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u1=userepo.findByUserName(username);
		
		return new org.springframework.security.core.userdetails
				.User(u1.getUserName(), u1.getUserPassword(), new ArrayList<>());
		
	}

}
