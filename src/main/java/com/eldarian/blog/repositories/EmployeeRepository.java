package com.eldarian.blog.repositories;

import com.eldarian.blog.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
