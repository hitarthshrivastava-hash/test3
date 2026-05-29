package com.api_nov.controller;

import com.api_nov.dto.APIResponse;
import com.api_nov.dto.EmployeeDto;
import com.api_nov.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity< APIResponse<EmployeeDto>> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto emp = employeeService.add(employeeDto);
        APIResponse<EmployeeDto> response = new APIResponse<>();
        if(emp!=null){
            response.setMessage("Created");
            response.setStatus(201);
            response.setData(emp);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }else{
            response.setMessage("Somethingg went wronng");
            response.setStatus(500);
            response.setData(emp);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteEmployee(
            @RequestParam long id
    ) {

        employeeService.deleteEmployee(id);
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("Created");
        response.setStatus(201);
        response.setData("dala is deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<EmployeeDto>> getEmployeeId(
            @PathVariable long id
    ) {
       EmployeeDto emp= employeeService.findEmployeeById(id);
        APIResponse<EmployeeDto> response = new APIResponse<>();
        response.setMessage("Fetched data");
        response.setStatus(200);
        response.setData(emp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/employee/all?pageNo=0&pageSize=3&sortBy=id
    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<EmployeeDto>>>getAllEmployee(
            @RequestParam(name="pageNo",defaultValue = "0",required = false) int pageNO,
            @RequestParam(name="pageSize",defaultValue = "2",required = false) int pageSize,
            @RequestParam(name="sortBy",defaultValue = "id",required = false) String sortBy
    ){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee(pageNO,pageSize,sortBy);
        APIResponse<List<EmployeeDto>> response = new APIResponse<>();
        response.setMessage("Fetched data");
        response.setStatus(200);
        response.setData(employeeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
