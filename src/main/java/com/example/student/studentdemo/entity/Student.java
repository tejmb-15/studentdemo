package com.example.student.studentdemo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//model class
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long rollno;
    private String name;
    private String section;
    public Student(long rollno, String name, String section) {
        this.rollno = rollno;
        this.name = name;
        this.section = section;
    }


    public Student() {
    }
    public long getRollno() {
        return rollno;
    }
    public void setRollno(long rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("rollno=").append(rollno);
        sb.append(", name=").append(name);
        sb.append(", section=").append(section);
        sb.append('}');
        return sb.toString();
    }

}
