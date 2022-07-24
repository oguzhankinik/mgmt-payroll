package com.kinik.mgmt.payroll.service.impl;

import com.kinik.mgmt.payroll.dto.EmployeeDto;
import com.kinik.mgmt.payroll.entity.EmployeeEntity;
import com.kinik.mgmt.payroll.exception.CodedException;
import com.kinik.mgmt.payroll.repo.EmployeeRepo;
import com.kinik.mgmt.payroll.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This class implements the {@link EmployeeService}.
 *
 * @author oguzhankinik
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto add(final EmployeeDto employeeDto) {
        log.debug("called insert employee. Content is " + employeeDto);

        try {
            Validate.notNull(employeeDto, "The employee must not be null");

            // create employee instance from employeeDto then save
            EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
            employeeEntity = employeeRepo.save(employeeEntity);


            EmployeeDto employeeDtoResp = modelMapper.map(employeeEntity, EmployeeDto.class);
            return employeeDtoResp;
        } catch (Exception e) {
            throw new CodedException("Unexpected an error occurred", e);
        }
    }

    @Override
    public EmployeeDto getById(final Long id) {
        log.debug("called get employee with id is " + id);

        Validate.inclusiveBetween(1, Long.MAX_VALUE, id, "The id must be positive number");
        try {
            Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(id);
            if (employeeEntity.isPresent()) {
                EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
                return employeeDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new CodedException("Unexpected an error occurred", e);
        }
    }

    @Override
    public List<EmployeeDto> list() {
        log.debug("called get all employees");

        try {
            List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
            List<EmployeeDto> employeeDtoList = Arrays
                    .asList(modelMapper.map(employeeEntityList, EmployeeDto[].class));
            return employeeDtoList;
        } catch (Exception e) {
            throw new CodedException("Unexpected an error occurred", e);
        }
    }

    @Override
    public Page<EmployeeDto> list(final Pageable pageable) {
        return null;
    }

    @Override
    public EmployeeDto edit(final EmployeeDto employeeDto) {
        log.debug("called update employee. Content is " + employeeDto);

        Validate.notNull(employeeDto, "The employee dto must not be null");
        try {
            Optional<EmployeeEntity> toBeUpatedEmployeeEntity = employeeRepo.findById(employeeDto.getId());
            EmployeeEntity employeeEntity;
            if (toBeUpatedEmployeeEntity.isPresent()) {
                employeeEntity = toBeUpatedEmployeeEntity.get();
            } else {
                //employeeEntity = new EmployeeEntity();
                throw new CodedException("Employee could not be found with this id: %s", employeeDto.getId());
            }
            employeeEntity.setFirstName(employeeDto.getFirstName());
            employeeEntity.setLastName(employeeDto.getLastName());
            employeeEntity.setRole(employeeDto.getRole());
            employeeEntity.setEmail(employeeDto.getEmail());

            EmployeeEntity savedEmployeeEntity = employeeRepo.save(employeeEntity);
            EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployeeEntity, EmployeeDto.class);
            return savedEmployeeDto;
        } catch (Exception e) {
            throw new CodedException("Unexpected an error occurred", e);
        }
    }
}
