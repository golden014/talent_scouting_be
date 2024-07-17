package org.enrichment.talent_scouting_backend.repositories;

import org.enrichment.talent_scouting_backend.enums.Role;
import org.enrichment.talent_scouting_backend.models.Dummy;
import org.enrichment.talent_scouting_backend.models.Student;
import org.enrichment.talent_scouting_backend.models.User;
import org.enrichment.talent_scouting_backend.models.requestmodels.RegisterStudentRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.nio.CharBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public int addUser(RegisterStudentRequest student) {
        String query = "INSERT INTO Student (studentID, nim, studentName, email, phoneNumber, dateOfBirth, major, address, city, state, profilePictureLink, profileDescription, personalLink) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                student.getStudentID(),
                student.getNim(),
                student.getStudentName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getDateOfBirth(),
                student.getMajor(),
                student.getAddress(),
                student.getCity(),
                student.getState(),
                student.getProfilePictureLink(),
                student.getProfileDescription(),
                student.getPersonalLink()
        );
    }

    public Optional<User> findByLoginStudent(String NIM) {
        try {
            String query = "SELECT * FROM Student WHERE nim = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, this::mapRowToUser, NIM));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setRole(Role.valueOf("Student"));
        //nnti perlu ganti pake oauth microsoft
        student.setPassword(passwordEncoder.encode(CharBuffer.wrap("admin123")));
        student.setStudentID(rs.getString("studentID"));
        student.setNim(rs.getString("nim"));
        student.setStudentName(rs.getString("studentName"));
        student.setEmail(rs.getString("email"));
        student.setPhoneNumber(rs.getString("phoneNumber"));
        student.setDateOfBirth(rs.getTimestamp("dateOfBirth").toLocalDateTime());
        student.setMajor(rs.getString("major"));
        student.setAddress(rs.getString("address"));
        student.setCity(rs.getString("city"));
        student.setState(rs.getString("state"));
        student.setProfilePictureLink(rs.getString("profilePictureLink"));
        student.setProfileDescription(rs.getString("profileDescription"));
        student.setPersonalLink(rs.getString("personalLink"));
        return student;
    }



}
