package flores.javafx.recap.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Worker {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty department;
    private SimpleIntegerProperty salary;


    public Worker(Integer id, String name, String email, String department, Integer salary){
     this.id = new SimpleIntegerProperty(id);
     this.name = new SimpleStringProperty(name);
     this.email = new SimpleStringProperty(email);
     this.department = new SimpleStringProperty(department);
     this.salary = new SimpleIntegerProperty(salary);

    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public Integer getSalary() {
        return salary.get();
    }

    public void setSalary(Integer salary) {
        this.salary.set(salary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", email=" + getEmail() +
                ", department=" + getDepartment() +
                ", salary=" + getSalary() +
                '}';
    }
}
