package com.upm.rh.RepoUSER;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.user;


public interface UserRepo extends JpaRepository<user, Integer> {
	
	user findByUsername(String username); 
	List<user> findByRole(String role);
	
	@Query(value = "SELECT e.idemploye from employe e , bulletin b WHERE e.IDEMPLOYE=b.IDEMPLOYE",nativeQuery = true)
	List<Integer> findIdHadBull();
	
	@Query(value = "SELECT login FROM employe WHERE idemploye=:idemp",nativeQuery = true)
	String findUsername(@Param("idemp") int idemp);
	
	@Query(value = "SELECT COUNT(`IDEMPLOYE`) FROM employe GROUP by DIPLOMEEMPLOYE",nativeQuery = true)
	List<BigInteger> findNumberEmp();
	
	@Query(value = "SELECT DIPLOMEEMPLOYE FROM employe GROUP by DIPLOMEEMPLOYE",nativeQuery = true)
	List<String> findRoleEmp();
	
	@Query(value = "select e.login from employe e WHERE e.login = :username",nativeQuery = true)
	String findCountUsername(@Param("username") String username);
	
	
}
