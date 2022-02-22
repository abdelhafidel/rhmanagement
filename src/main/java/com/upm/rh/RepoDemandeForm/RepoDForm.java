package com.upm.rh.RepoDemandeForm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upm.rh.entity.DemandeFormation;

public interface RepoDForm extends JpaRepository<DemandeFormation, Integer> {

	@Query(value = "SELECT formation.IDFORMATION from formation WHERE formation.IDFORMATION IN (SELECT demandeformation.IDFORMATION FROM demandeformation WHERE demandeformation.IDFORMATION = formation.IDFORMATION AND demandeformation.IDEMPLOYE = :idemp )", nativeQuery = true)
	List<Integer> IdFormEmp(@Param("idemp") int idemp);

}
