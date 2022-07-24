package com.kinik.mgmt.payroll.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author oguzhankinik
 */
@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "{id}")
@ToString
public class EmployeeEntity extends UserAccountEntity {

    @Column(length = 255)
    private String firstName;

    @Column(length = 255)
    private String lastName;

    @Column(length = 255)
    private String role;

    @Column(length = 255)
    private String email;
}
