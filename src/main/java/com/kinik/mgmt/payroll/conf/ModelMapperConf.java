package com.kinik.mgmt.payroll.conf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class is helper the to map objects' conversion.
 *
 * @author oguzhankinik
 */
@Configuration
public class ModelMapperConf {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
