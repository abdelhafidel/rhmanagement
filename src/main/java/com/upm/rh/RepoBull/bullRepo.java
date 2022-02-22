package com.upm.rh.RepoBull;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.Bulletin;

public interface bullRepo extends JpaRepository<Bulletin, Integer> {

	@Query(value = "SELECT b.* FROM bulletin b WHERE b.idemploye=:idemp",nativeQuery = true)
	Bulletin findUserBull(@Param("idemp") int idemp);
	
	@Query(value = "select sum(b.NBHEURESTRAVAILLER) from bulletin b",nativeQuery = true)
	int SumHT();
	
	@Query(value = "select sum(b.NBHEURBENUS) from bulletin b",nativeQuery = true)
	int SumHB();
	
	@Query(value = "SELECT b.NBHEURESTRAVAILLER FROM bulletin b WHERE b.IDEMPLOYE=:idemp",nativeQuery = true)
	int HT(@Param("idemp") int id);
}
