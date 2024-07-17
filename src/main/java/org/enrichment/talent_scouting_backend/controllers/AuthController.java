package org.enrichment.talent_scouting_backend.controllers;

import org.enrichment.talent_scouting_backend.helper.UserAuthProvider;
import org.enrichment.talent_scouting_backend.models.Student;
import org.enrichment.talent_scouting_backend.models.User;
import org.enrichment.talent_scouting_backend.models.requestmodels.RegisterStudentRequest;
import org.enrichment.talent_scouting_backend.services.AuthService;
import org.enrichment.talent_scouting_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserAuthProvider userAuthProvider;

//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        return authService.login(username, password);
//    }

    @PostMapping
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam char[] password) {
        User user = authService.login(username, password);

        user.setToken(userAuthProvider.createToken(username));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody RegisterStudentRequest req) {
        return studentService.addStudent(req);
    }

}
