package org.example.course_management.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
    
    @JsonIgnore
    private boolean submitted;
    
    @JsonIgnore
    private boolean graded;
    
    @JsonIgnore
    private String feedback;
    
    @JsonIgnore
    private List<Student> submittedStudents = new ArrayList<>(); 
    
    @JsonIgnore
    private List<String> feedbackList = new ArrayList<>();

    public Assignment(String title, String description) {

        this.title = title;
        this.description = description;
        this.submitted = false;
        this.graded = false;
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

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public List<Student> getSubmittedStudents() {
        return submittedStudents;
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }

    public void addSubmittedStudent(Student student) {
        submittedStudents.add(student);
    }

    public void addFeedback(String feedback) {
        feedbackList.add(feedback);
    }
}
