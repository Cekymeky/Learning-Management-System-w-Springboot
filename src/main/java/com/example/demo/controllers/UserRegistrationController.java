package main.java.com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.user.Model.User;
import com.education.user.Service.UserRegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class UserRegistrationController {
    
 @Autowired
private UserRegistrationService userservice;

    @PostMapping("/signup")
    public User registration(@RequestBody User u){

        boolean res = userservice.addPerson(u);
        if(res){
           return userservice.getUser(u.getId());
        }

        return null;
       
    }

    @PostMapping("/login")
    public User login(@RequestParam(name="id")int id,@RequestParam(name="password")String password){

        if (userservice.isUser(id,password )!= null){
            return userservice.isUser(id,password );
       }
       return null;
    }

      @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        userservice.deleteUser(id);
        
    }

    @GetMapping("/view/{id}")
	public User getPerson(@PathVariable("id") int id) {
		return userservice.getUser(id);
	}
        
   
        
    @GetMapping("/viewall")
	public List<User> getAll() {
		return userservice.getAllUsers();
	}
    
    
}