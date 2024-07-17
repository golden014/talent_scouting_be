package org.enrichment.talent_scouting_backend.services;

import org.enrichment.talent_scouting_backend.models.Dummy;
import org.enrichment.talent_scouting_backend.models.Student;
import org.enrichment.talent_scouting_backend.models.requestmodels.RegisterStudentRequest;
import org.enrichment.talent_scouting_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    public int addStudent(RegisterStudentRequest student) {
        return userRepository.addUser(student);
    }

}
