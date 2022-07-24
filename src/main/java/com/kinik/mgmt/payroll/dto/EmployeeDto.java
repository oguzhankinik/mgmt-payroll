package com.kinik.mgmt.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author oguzhankinik
 */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private String email;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
