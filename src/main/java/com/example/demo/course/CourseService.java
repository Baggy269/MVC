package com.example.demo.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("CS1","course1",3),
            new Course("CS2","course2",3),
            new Course("CS3","course3",2)
    ));

    public List<Course> getCourses(){
        return courses;
    }

    public Course getCourse(String code){
        return courses.stream().filter(c -> c.getCode().equals(code)).findFirst().get();
    }

    public void addCourse(Course course){
        courses.add(course);
    }

}
