package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @RequestMapping("/courses/{code}")
    public Course getCourse(@PathVariable String code){
        return courseService.getCourse(code);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

}
