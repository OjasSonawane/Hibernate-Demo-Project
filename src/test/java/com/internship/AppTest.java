package com.internship;

import com.internship.entities.Student;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public void testGetStudentById() {
        StudentService studentService = new StudentService();
        Student student = studentService.getByID(1);
        if (student != null) {
            System.out.println(student.getName());
        } else {
            System.out.println("Student not found");
        }
    }
}
