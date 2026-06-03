package com.luv2code.demo.entity;

import java.util.List;

public class ResponseObj {
    private String message;
    private Object students;

    public ResponseObj(){}

    public ResponseObj(String message, Object students) {
        this.message = message;
        this.students = students;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public void addStudent(Student student){
//        this.students.add(student);
//    }

    public Object getStudents() {
        return students;
    }
}
