package com.zpasthapana.repo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zpasthapana.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	@Query(value = "select e from Employee e where e.isActive = 1 and e.retierment.retirementDate < :retirementDate")
	Page<Employee> findAllRetieredEmployee(@Param("retirementDate") Date retirementDate, Pageable paging);

	@Query(value = "select e from Employee e left join e.retierment r where e.isActive = 1 and (e.retierment IS NULL or r.retirementDate > :retirementDate)")
	Page<Employee> findAllWorkingEmployee(@Param("retirementDate") Date retirementDate, Pageable paging);

	@Query(value = "select e from Employee e where e.isActive = 1 and e.retierment.retirementDate < :retirementDate and (:zpId is null or e.employeeWorkLocation.zpId = :zpId) "
			+ " and (:devisionId is null or e.employeeWorkLocation.divisionId = :devisionId) and (:departmentId is null or e.employeeWorkLocation.departmentId = :departmentId)"
			+ " and (:talukaId is null or e.employeeWorkLocation.taluka = :talukaId)")
	Page<Employee> findAllRetieredEmployee(Long devisionId, Long zpId, Long departmentId, Long talukaId, Date retirementDate,
			Pageable paging);

	@Query(value = "select e from Employee e left join e.retierment r where e.isActive = 1 and (e.retierment IS NULL or r.retirementDate > :retirementDate) and (:zpId is null or e.employeeWorkLocation.zpId = :zpId) "
			+ " and (:devisionId is null or e.employeeWorkLocation.divisionId = :devisionId) and (:departmentId is null or e.employeeWorkLocation.departmentId = :departmentId)"
			+ "	and (:talukaId is null or e.employeeWorkLocation.taluka = :talukaId)")
	Page<Employee> findAllWorkingEmployee(Long devisionId, Long zpId, Long departmentId, Long talukaId, Date retirementDate,
			Pageable paging);

	@Query(value = "select e from Employee e where e.isActive = 1 and (:zpId is null or e.employeeWorkLocation.zpId = :zpId) "
			+ " and (:devisionId is null or e.employeeWorkLocation.divisionId = :devisionId) and (:departmentId is null or e.employeeWorkLocation.departmentId = :departmentId)"
			+ " and (:talukaId is null or e.employeeWorkLocation.taluka = :talukaId)")
	Page<Employee> findAllByPermission(Long devisionId, Long zpId, Long departmentId, Long talukaId, Pageable paging);

}
