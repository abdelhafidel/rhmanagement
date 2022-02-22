package com.upm.rh.RepoSalaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upm.rh.entity.Salaire;

public interface RepoSalaire extends JpaRepository<Salaire, Integer> {
	
	@Query(value = "SELECT SUM(s.SALAIREBASE) from salaire s",nativeQuery = true)
	long sumSalaire();
	
}
