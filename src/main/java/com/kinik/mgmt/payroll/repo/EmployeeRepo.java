package com.kinik.mgmt.payroll.repo;

import com.kinik.mgmt.payroll.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface provide data access
 *
 * @author oguzhankinik
 */
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

}
