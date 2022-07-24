package com.kinik.mgmt.payroll.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * @author oguzhankinik
 */
@Getter
@Setter
@ToString
public class UserAccountEntity extends BaseEntity {

    @Column
    protected boolean active = true;

}
