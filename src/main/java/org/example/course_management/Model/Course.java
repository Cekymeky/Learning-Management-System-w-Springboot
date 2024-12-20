package org.example.course_management.Model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer duration;

    @JsonIgnore
    private ArrayList<Lesson> Lessons = new  ArrayList<>() ;
    
    @JsonIgnore
    private ArrayList<Student> Students = new  ArrayList<>() ;

    @JsonIgnore
    public AtomicLong LessonCounter = new AtomicLong(0) ; 

    public ArrayList<Lesson> GetAllLessons() {
        return this.Lessons;
    }

    public void AddLesson(Lesson lesson) {
        Lessons.add(lesson) ;
    }

    public void UpdateLesson(Lesson lesson , int index) {
        Lessons.set(index, lesson) ;
    }

    public void DeleteLesson(int index) {
        Lessons.remove(index) ;
    }

    public Lesson GetLesson(int index) {
        return Lessons.get(index) ;
    }

    public void EnrollStudent(Student student) {
        Students.add(student);
    }

    public void DeleteStudent(Student student) {
        Students.remove(student);
    }

    public ArrayList<Student> GetAllStudents() {
        return Students ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}