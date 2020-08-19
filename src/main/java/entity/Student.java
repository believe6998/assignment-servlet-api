package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {
    @Id
    private Integer id;
    @Column
    private String rollNumber;
    @Column
    private String name;
    @Column
    private Integer gender;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String country;
    @Column
    private String dob;

    public Student() {
    }

    public Student(Integer id, String rollNumber, String name, Integer gender, String email, String phone, String country, String dob) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}


