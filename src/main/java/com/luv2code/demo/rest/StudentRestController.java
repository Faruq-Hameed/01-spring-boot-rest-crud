package com.luv2code.demo.rest;

import com.luv2code.demo.entity.ResponseObj;
import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //decorating the class as route handler
@RequestMapping("/api") //the handler base route i.e all request to this path will come here
public class StudentRestController {
    private List<Student> students;

    @PostConstruct //load once the bean is created
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Faruq0", "Hameed0"));
        students.add(new Student("Faruq1", "Hameed1"));
        students.add(new Student("Faruq2", "Hameed2"));
    }

    //get all students
    @GetMapping()
    public ResponseObj getAllStudents(){
        return  new ResponseObj("Students fetched successfully", this.students);
    }

    //get all students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.students;
    }

    //get student by id

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //check the studentId again the list size
        if(studentId >= this.students.size() || studentId < 0){
            throw new StudentNotFoundException("Student with id <h1>" + studentId + "</h1> not found");
        }
        return this.students.get(studentId); //get student at that index
    }


    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error /* error body */, HttpStatus.NOT_FOUND /*status code*/);
    }

}

