package com.kinik.mgmt.payroll.req;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author oguzhankinik
 */
@Data
@AllArgsConstructor(staticName = "build")
public class EmployeeUpdateReq {

    @Positive(message = "We only allow positive value.")
    @NotNull
    private Long id;

    @NotNull(message = "First Name can not be null")
    @NotBlank(message = "First Name is mandatory.")
    private String firstName;

    @NotNull(message = "Last Name can not be null")
    @NotBlank(message = "Last Name is mandatory.")
    private String lastName;

    @NotNull(message = "Email can not be null")
    @Email(message = "Email is not valid.")
    private String email;

    // TODO @oguzhankinik 20220724 use enum
    @NotNull(message = "Role can not be null")
    @NotBlank(message = "Role is mandatory.")
    private String role;

}
