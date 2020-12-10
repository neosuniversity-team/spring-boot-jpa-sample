package com.neosuniversity.jpa.repo;

import com.neosuniversity.jpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFirstName(String firstName);

    @Query("SELECT emp FROM Employee emp Where emp.firstName = :firstName")
    List<Employee> findEmployeeByFirstName(@Param("firstName") String firstName);


}
