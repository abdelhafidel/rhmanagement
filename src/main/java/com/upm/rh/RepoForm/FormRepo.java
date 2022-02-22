package com.upm.rh.RepoForm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.Formation;

public interface FormRepo extends JpaRepository<Formation, Integer> {

	@Query(value = "SELECT FORMATIONLIBELLE from formation WHERE IDFORMATION=:id", nativeQuery = true)
	String findFormationLibelle(@Param("id") int id);

	@Query(value = "SELECT b.formationlibelle FROM demandeformation a INNER JOIN formation b on a.idformation = b.idformation GROUP by a.idformation, b.formationlibelle", nativeQuery = true)
	List<String> findFormationNames();
	
	@Query(value = "SELECT COUNT(a.idemploye) FROM demandeformation a INNER JOIN formation b on a.idformation = b.idformation GROUP by a.idformation, b.formationlibelle", nativeQuery = true)
	List<BigInteger> findSubs();
	
	
	

}
