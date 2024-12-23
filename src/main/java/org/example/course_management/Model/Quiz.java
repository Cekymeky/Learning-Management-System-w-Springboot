package org.example.course_management.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @JsonIgnore
    private boolean isGraded;

    @JsonIgnore
    private String feedback;

    @JsonIgnore
    private boolean isSubmitted;
    
    private List<Student> submittedStudents=new ArrayList<>();
    public Quiz(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isGraded = false;
        this.feedback = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public boolean isSubmitted() {
        return isSubmitted;
    }
    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
    public List<Student> getSubmittedStudents() {
        return submittedStudents;
    }

    public void addSubmittedStudent(Student student) {
        this.submittedStudents.add(student);
    }

}