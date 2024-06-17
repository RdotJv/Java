package com.example.sqltesting.repositories;

import com.example.sqltesting.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ProfileRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProfile(Profile profile) {
        String sql = "INSERT INTO new_table VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, profile.getUserName(), profile.getUserAge());
        System.out.println("added!");
    }

    public List<Profile> getProfiles() {
        String sql = "SELECT * FROM new_table";
        return jdbcTemplate.query(sql, (rs, rownum) -> {
            Profile p = new Profile(rs.getString("username"), rs.getInt("userage"));
            p.setUserid(rs.getInt("userid"));
            return p;
        });
    }
}

