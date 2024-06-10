package com.test.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    public static Logger log = LoggerFactory.getLogger(SchoolController.class);

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody School entity) {
        //TODO: create school
        service.saveSchool(entity);
    }
    
    @GetMapping
    public ResponseEntity<List<School>> getMethodName() {
        //TODO: save school
        return ResponseEntity.ok().body(service.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudent(@PathVariable("school-id") Integer schoolId) {
        log.info("SchoolId: ",schoolId);
        return ResponseEntity.ok().body(service.findSchoolsWithStudents(schoolId));
    }
    
    
}
