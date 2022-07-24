package com.kinik.mgmt.payroll.service;

import com.kinik.mgmt.payroll.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * This interface provides the contract of the Employee Service.
 *
 * @author oguzhankinik
 */
public interface EmployeeService {

    EmployeeDto add(final EmployeeDto employeeDto);

    EmployeeDto getById(final Long id);

    List<EmployeeDto> list();

    Page<EmployeeDto> list(final Pageable pageable);

    EmployeeDto edit(final EmployeeDto employeeDto);

}
