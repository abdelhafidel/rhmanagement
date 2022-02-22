package com.upm.rh.RepoAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upm.rh.entity.user;

public interface AdminRepo extends JpaRepository<user, Integer> {
	
	user  findByUsername(String username);
	
}
