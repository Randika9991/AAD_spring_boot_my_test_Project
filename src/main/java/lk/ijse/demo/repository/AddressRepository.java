package lk.ijse.demo.repository;/*this application is copyright protected
    Author : kumara
    Date : 2/14/2024
*/

import lk.ijse.demo.entity.Address;
import lk.ijse.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
