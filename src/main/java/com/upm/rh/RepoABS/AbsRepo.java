package com.upm.rh.RepoABS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.Absences;

public interface AbsRepo extends JpaRepository<Absences, Integer> {
	
	@Query(value = "SELECT c.* from absences c WHERE c.idemploye=:id",nativeQuery = true)
	List<Absences> findAbs(@Param("id")int id);

}
