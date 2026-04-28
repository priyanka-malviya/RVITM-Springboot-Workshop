package com.example.myfirstproject;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public String updateStudent(int id, Student updatedStudent) {
        if(studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            studentRepository.save(updatedStudent);
            return "Student updated successfully";
        }
        return "Student not found";
    }
    public String deleteStudent(int id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";

        }
        return "Student not found";
    }
}
