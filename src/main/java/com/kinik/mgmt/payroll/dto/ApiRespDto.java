package com.kinik.mgmt.payroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Recommendation: Use statusCode to by pass Proxy rule if exists
 *
 * @author oguzhankinik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRespDto {

    private boolean success;

    private int statusCode;

    private String displayMessage;

    private String internalMessage;

    private Object data;

}
