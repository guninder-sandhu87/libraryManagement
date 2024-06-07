package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    private String empPh;
    private String empPhone;

    public Employee(String empName, String empPh, String empPhone) {
        this.empName = empName;
        this.empPh = empPh;
        this.empPhone = empPhone;
    }

    public Employee() {

    }

    public int getEmpId() {
        return empId;
    }



    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPh() {
        return empPh;
    }

    public void setEmpPh(String empPh) {
        this.empPh = empPh;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPh='" + empPh + '\'' +
                ", empPhone='" + empPhone + '\'' +
                '}';
    }
}
