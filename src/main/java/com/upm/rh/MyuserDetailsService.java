package com.upm.rh;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upm.rh.RepoUSER.UserRepo;
import com.upm.rh.entity.user;

@Service
public class MyuserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo rp;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		user user = rp.findByUsername(username);
		userPr userPrincipal = new userPr(user);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		return userPrincipal;
	}
	



}
