package javaee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class PartTimeEmployee extends Employee {
    @Column(name = "hour")
    private int hour;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, String surname, int hour) {
        super(name, surname);
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hour=" + hour +
                '}';
    }
}
