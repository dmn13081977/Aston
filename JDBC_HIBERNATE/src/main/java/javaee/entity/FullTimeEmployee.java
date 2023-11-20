package javaee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FullTimeEmployee extends Employee {
    @Column(name = "salary")
    private int salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, String surname, int salary) {
        super(name, surname);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                '}';
    }
}
