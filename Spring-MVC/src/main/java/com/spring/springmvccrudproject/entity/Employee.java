package com.spring.springmvccrudproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private  String email;

    // create non-valid constructor
    public Employee() {

    }

    // value contructor (do not include id)
    public Employee(String theFirstName, String theLastName, String theEmail) {
        this.firstName = theFirstName;
        this.lastName = theLastName;
        this.email = theEmail;
    }

    public Employee(int theId, String theName, String theLName, String email) {
        this.id = theId;
        this.firstName = theName;
        this.lastName = theLName;
        this.email = email;
    }

    // getter setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // if you are using Lombok, just use @Getter and @Setter anotations.


    // toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
