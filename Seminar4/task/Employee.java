package task;

import java.time.LocalDateTime;

public class Employee {
    private int id;
    private String phone;
    private String name;
    private LocalDateTime hireDate;

    private static int idE = 0;

    public Employee(String phone, String name, LocalDateTime hireDate) {
        this.id = ++idE;
        this.phone = phone;
        this.name = name;
        this.hireDate = hireDate;
    }

    public int getWorkingYears() {
        int start = hireDate.getYear();
        int now = LocalDateTime.now().getYear();
        return now - start;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
