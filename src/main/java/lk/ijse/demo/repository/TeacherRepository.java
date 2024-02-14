package lk.ijse.demo.repository;/*this application is copyright protected
    Author : kumara
    Date : 2/14/2024
*/

import lk.ijse.demo.entity.Student;
import lk.ijse.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
