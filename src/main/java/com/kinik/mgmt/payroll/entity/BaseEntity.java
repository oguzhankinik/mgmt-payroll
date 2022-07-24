package com.kinik.mgmt.payroll.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author oguzhankinik
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Getter
    @Setter
    @Version
    protected Long version;
    @Getter
    @Setter
    @Column
    protected LocalDateTime createTime;
    @Getter
    @Setter
    @Column
    protected LocalDateTime updateTime;
    @Id
    @GeneratedValue
    //@ApiModelProperty(value = "Purchasing Invoice ID")
    private Long id;

    @PrePersist
    protected void populatePrePersist() {
        createTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void populatePreUpdate() {
        updateTime = LocalDateTime.now();
    }

}
