package com.kinik.mgmt.payroll.restapi;

import com.kinik.mgmt.payroll.dto.ApiRespDto;
import com.kinik.mgmt.payroll.dto.EmployeeDto;
import com.kinik.mgmt.payroll.req.EmployeeInsertReq;
import com.kinik.mgmt.payroll.req.EmployeeUpdateReq;
import com.kinik.mgmt.payroll.service.EmployeeService;
import com.kinik.mgmt.payroll.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * API to manage employees.
 *
 * @author oguzhankinik
 */
@RestController
@RequestMapping(path = ApiPaths.EMPLOYEES,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity<?> insertEmployee(@Valid @RequestBody EmployeeInsertReq employeeInsertReq) {
        log.debug("called insert employee. Content is " + employeeInsertReq);

        EmployeeDto employeeDto = modelMapper.map(employeeInsertReq, EmployeeDto.class);
        employeeDto = employeeService.add(employeeDto);

        ApiRespDto apiRespDto = new ApiRespDto(true, HttpStatus.OK.ordinal(), "Employee has been inserted successfully.",
                "", employeeDto);

        return ResponseEntity.ok(apiRespDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable final long id) {
        log.debug("called get employee with id is " + id);

        EmployeeDto employeeDto = employeeService.getById(id);

        ApiRespDto apiRespDto = new ApiRespDto(true, HttpStatus.OK.ordinal(), "Employee has been retrieved successfully.",
                "", employeeDto);
        return ResponseEntity.ok(apiRespDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        log.debug("called get all employees");

        List<EmployeeDto> employeeDtoList = employeeService.list();

        ApiRespDto apiRespDto = new ApiRespDto(true, HttpStatus.OK.ordinal(), "All employees have been retrieved successfully.",
                "", employeeDtoList);
        return ResponseEntity.ok(apiRespDto);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeUpdateReq employeeUpdateReq) {
        log.debug("called update employee. Content is " + employeeUpdateReq);

        EmployeeDto employeeDto = modelMapper.map(employeeUpdateReq, EmployeeDto.class);
        employeeDto = employeeService.edit(employeeDto);

        ApiRespDto apiRespDto = new ApiRespDto(true, HttpStatus.OK.ordinal(), "Employee has been updated successfully.",
                "", employeeDto);
        return ResponseEntity.ok(apiRespDto);
    }

}
