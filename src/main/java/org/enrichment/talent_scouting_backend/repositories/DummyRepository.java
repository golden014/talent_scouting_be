package org.enrichment.talent_scouting_backend.repositories;

import org.enrichment.talent_scouting_backend.models.Dummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DummyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Dummy> getAllDummy() {
        String query = "SELECT * FROM msDummy";
        //execute the query and map the results into Dummy objects
        return jdbcTemplate.query(query, this::mapRowToDummy);
    }

    public Dummy getDummyById(String id) {
        String query = "SELECT * FROM msDummy WHERE id = ?";
        return jdbcTemplate.queryForObject(query, this::mapRowToDummy, id);
    }

    public int addDummy(Dummy dummy) {
        String query = "INSERT INTO msDummy (id, name, date, amount) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                dummy.getID(),
                dummy.getName(),
                dummy.getdate(),
                dummy.getAmount());
    }

    private Dummy mapRowToDummy(ResultSet rs, int rowNum) throws SQLException {
        Dummy dummy = new Dummy();
        dummy.setID(rs.getString("id"));
        dummy.setName(rs.getString("name"));
        // retrieve timestamp from ResultSet
        Timestamp timestamp = rs.getTimestamp("date");

        // convert timestamp to LocalDateTime
        LocalDateTime localDateTime = null;
        if (timestamp != null) localDateTime = timestamp.toLocalDateTime();

        dummy.setDate(localDateTime);
        dummy.setAmount(rs.getInt("amount"));
        return dummy;
    }
}
