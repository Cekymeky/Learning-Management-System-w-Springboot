package org.example.course_management.Controller;

import org.example.course_management.Model.Assignment;
import org.example.course_management.Model.Student;
import org.example.course_management.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/GetCourse/{id}/CreateAssignment")
    public Assignment CreateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        return  assignmentService.createAssignment(id, assignment);
    }

    @GetMapping("/GetCourse/{id}/getAssignmentsForCourse")
    public ArrayList<Assignment> getAssignmentsForCourse(@PathVariable Long id) {
        return assignmentService.getAssignmentsForCourse(id);
    }

    @GetMapping("/GetCourse/{id}/getAssignment/{AssignmentId}")
    public Assignment getAssignment(@PathVariable Long id, @PathVariable Long AssignmentId) {
        return assignmentService.getAssignment(id,AssignmentId);
    }

    @PostMapping("/GetCourse/{id}/getAssignment/{AssignmentId}/submitAssignment")
    public String submitAssignment(@PathVariable Long AssignmentId, @PathVariable Long id,@RequestBody Student student ) {
        if (assignmentService.submitAssignment(AssignmentId,id,student)) return "Assignment Submitted";
        return "Assignment Not Submitted";
    }

    @PostMapping("/GetCourse/{id}/getAssignment/{AssignmentId}/gradeAssignment")
    public String gradeAssignment(@PathVariable Long AssignmentId, @PathVariable Long id) {
        if(assignmentService.gradeAssignment(AssignmentId, id)) return "Assignment Graded";
        return "Assignment Not Graded";
    }

    @GetMapping("/GetCourse/{id}/getAssignment/{AssignmentId}/getAssignmentFeedback/{StudentId}")
    public String getAssignmentFeedback(@PathVariable Long AssignmentId, @PathVariable Long id,@PathVariable Long StudentId) {
        return assignmentService.getAssignmentFeedback(AssignmentId,id,StudentId);
    }

}