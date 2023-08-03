//package com.hon.keycloak.controller;
//
//import com.hon.keycloak.model.Employee;
//import com.hon.keycloak.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
////@RequestMapping("/api/v1/demo")
////public class DemoController {
////
////    @GetMapping
////    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
////    public String hello(){
////        return "Hello from Spring boot & KeyCloak";
////    }
////
////    @GetMapping("/hello-2")
////    @PreAuthorize("hasRole('client_admin')")
////    public String hello2(){
////        return "Hello from Spring boot & KeyCloak - ADMIN";
////    }
////}
//@RequestMapping("/employees")
//public class DemoController {
//
//    @Autowired
//    private EmployeeService service;
//
//    //this method can be accessed by user whose role is user and admin
//    @GetMapping("/{employeeId}")
//    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
//    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
//        return ResponseEntity.ok(service.getEmployee(employeeId));
//    }
//
//    //this method can be accessed by user whose role is admin
//    @GetMapping
//    @PreAuthorize("hasRole('client_admin')")
//    public ResponseEntity<List<Employee>> findALlEmployees() {
//        return ResponseEntity.ok(service.getAllEmployees());
//    }
//}
