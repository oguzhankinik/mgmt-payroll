package com.kinik.mgmt.payroll;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kinik.mgmt.payroll.dto.EmployeeDto;
import com.kinik.mgmt.payroll.entity.EmployeeEntity;
import com.kinik.mgmt.payroll.exception.CodedException;
import com.kinik.mgmt.payroll.repo.EmployeeRepo;
import com.kinik.mgmt.payroll.req.EmployeeInsertReq;
import com.kinik.mgmt.payroll.req.EmployeeUpdateReq;
import com.kinik.mgmt.payroll.service.EmployeeService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author oguzhankinik
 */
@SpringBootTest
class PayrollApplicationTests {

    private String baseUri = "http://localhost:8080/v1/employees";

    public static RestTemplate restTemplate;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;
    @MockBean
    private EmployeeRepo employeeMockRepo;

    @BeforeAll
    public static void beforeAll() {
        restTemplate = new RestTemplate();
        /*List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        restTemplate.setMessageConverters(messageConverters);*/
    }

    ///@Test
    void testInsertEmployee() throws URISyntaxException {
        EmployeeInsertReq employeeInsertReq = EmployeeInsertReq.build("Suleyman Oguzhan", "Kinik", "Software Developer", "em@il.co");
        String response = restTemplate.postForObject(new URI(baseUri), employeeInsertReq, String.class);
        assertTrue(response.contains("\"success\": true,") );
        assertTrue(response.contains("\"firstName\": \"Suleyman Oguzhan"));
    }

    ///@Test
    void testGetEmployee() throws URISyntaxException {
        EmployeeInsertReq employeeInsertReq = EmployeeInsertReq.build("Suleyman Oguzhan", "Kinik", "Software Developer", "em@il.co");
        EmployeeDto employeeDto = restTemplate.postForObject(new URI(baseUri), employeeInsertReq, EmployeeDto.class);
        assertEquals("Suleyman Oguzhan", employeeDto.getFirstName());
        assertEquals("Kinik", employeeDto.getLastName());
    }

    @Test
    void testGetAllEmployees(){
        List<EmployeeEntity> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(EmployeeEntity.build("Suleyman Oguzhan", "Kinik", "Software Developer", "em@il.com"));
        employeeDtoList.add(EmployeeEntity.build("Doga", "Kinik", "Student", "em@il.com"
        ));

        when(employeeMockRepo.findAll()).thenReturn(employeeDtoList);
        assertEquals(2, employeeService.list().size());
    }

    ///@Test
    void testUpdateEmployee() throws URISyntaxException {
        EmployeeInsertReq employeeInsertReq = EmployeeInsertReq.build("Suleyman Oguzhan", "Kinik", "Software Developer", "em@il.co");
        restTemplate.postForObject(new URI(baseUri), employeeInsertReq, EmployeeDto.class);

        EmployeeUpdateReq employeeUpdateReq = EmployeeUpdateReq.build(1L,"Suleyman Oguzhan", "Kinik", "Software Developer Team Lead", "em@il.co");
        restTemplate.put(new URI(baseUri), employeeUpdateReq);

        Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(employeeUpdateReq.getId());
        assertTrue(employeeEntity.isPresent());
        assertEquals("Software Developer Team Lead", employeeEntity.get().getRole());
    }

}
