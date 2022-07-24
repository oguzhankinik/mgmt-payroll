package com.kinik.mgmt.payroll;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author oguzhankinik
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Payroll Management", version = "1.0", description = "This API provides management of employees"))
public class PayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }

}
