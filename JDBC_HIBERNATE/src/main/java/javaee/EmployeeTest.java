package javaee;

import javaee.entity.Employee;
import javaee.entity.FullTimeEmployee;
import javaee.entity.PartTimeEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeTest {
    FullTimeEmployee fullTimeEmployee;
    PartTimeEmployee partTimeEmployee;
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(FullTimeEmployee.class)
                .addAnnotatedClass(PartTimeEmployee.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

           List<Employee> employees = session.createQuery("from Employee").getResultList();
                System.out.println(employees);

            session.getTransaction().commit();
        }
    }
}
