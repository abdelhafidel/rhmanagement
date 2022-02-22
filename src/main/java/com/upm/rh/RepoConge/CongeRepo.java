package com.upm.rh.RepoConge;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.Conge;

public interface CongeRepo extends JpaRepository<Conge, Integer> {
	
	@Query(value = "select c.* from conge c where c.IDCONGE in (select d.IDCONGE from demande d where d.IDEMPLOYE = :idemp)",nativeQuery = true)
	List<Conge> findconge(@Param("idemp")int idemp);
	
	

}
