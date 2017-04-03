package com.example;

/**
 * Created by natete on 03/04/17.
 */
public class Employee {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String birthDate;
    private final String title;
    private final String dept;

    public Employee() {
        super();
        id = 0;
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        birthDate = "";
        title = "";
        dept = "";
    }

    public Employee(long id, String firstName, String lastName, String email, String phone, String birthDate,
            String title, String dept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.title = title;
        this.dept = dept;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", phone='" + phone + '\''
                + ", birthDate='" + birthDate + '\''
                + ", title='" + title
                + '\'' + ", dept='"
                + dept + '\''
                + '}';
    }
}
