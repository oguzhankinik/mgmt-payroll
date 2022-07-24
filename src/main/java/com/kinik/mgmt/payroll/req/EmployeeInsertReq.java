package com.kinik.mgmt.payroll.req;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author oguzhankinik
 */
@Data
@AllArgsConstructor(staticName = "build")
public class EmployeeInsertReq {

    @NotNull(message = "First Name can not be null")
    @NotBlank(message = "First Name is mandatory.")
    private String firstName;

    @NotNull(message = "Last Name can not be null")
    @NotBlank(message = "Last Name is mandatory.")
    private String lastName;

    // TODO @oguzhankinik 20220724 use enum
    @NotNull(message = "Role can not be null")
    @NotBlank(message = "Role is mandatory.")
    private String role;

    @NotNull(message = "Email can not be null")
    @Email(message = "Email is not valid.")
    private String email;

}
