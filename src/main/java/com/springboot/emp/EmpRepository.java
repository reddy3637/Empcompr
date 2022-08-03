package com.springboot.emp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpRepository extends JpaRepository<EmpEntity, Integer>{

		public EmpEntity findByName(String name);
		
		@Query(value = "select id, name, salary, designation from employee order by salary desc, name asc", nativeQuery=true)
		public List<EmpEntity> findAllBySalary();
}
