package lk.ijse.demo.controller;/*this application is copyright protected
    Author : kumara
    Date : 2/14/2024
*/

import lk.ijse.demo.entity.Student;
import lk.ijse.demo.entity.Teacher;
import lk.ijse.demo.repository.StudentRepository;
import lk.ijse.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherRepository repository;

    @PostMapping
    public Teacher addStudent(@RequestBody Teacher teacher) {
        Teacher addedStudent = repository.save(teacher);
        return addedStudent;
    }
}
