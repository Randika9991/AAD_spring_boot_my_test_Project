package lk.ijse.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cust_id")
    private int custId;
    @Column(name = "Cust_name")
    private String custName;
    @Column(name = "Cust_address")
    private String custAddress;
    @Column(name = "Cust_salary")
    private String custSalary;
    @Column(name = "Image_path")
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Student() {

    }

    public Student(int custId, String custName, String custAddress, String custSalary) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custSalary = custSalary;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustSalary() {
        return custSalary;
    }

    public void setCustSalary(String custSalary) {
        this.custSalary = custSalary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custSalary='" + custSalary + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
