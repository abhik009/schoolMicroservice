package com.test.school;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.school.client.StudentClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    
    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School student){
        repository.save(student);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        School school = repository.findById(schoolId).orElse(School.builder()
        .name("NOT_FOUND")
        .email("NOT_FOUND")
        .build());
        List<Student> students=client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
    }
}