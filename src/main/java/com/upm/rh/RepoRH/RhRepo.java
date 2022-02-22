package com.upm.rh.RepoRH;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upm.rh.entity.user;

public interface RhRepo extends JpaRepository<user, Integer> {
	
	user findByUsername(String username);

}