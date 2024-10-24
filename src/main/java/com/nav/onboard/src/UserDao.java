package com.nav.onboard.src;

import com.nav.onboard.model.SignUpResponse;
import com.nav.onboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    protected static String INSERTUSER = "INSERT INTO USER (email, password) VALUES (:email, :password) ";

    protected static String FINDUSER = "SELECT email from USER WHERE email = :email and password = :password ";

    public SignUpResponse signup(User user){

        SignUpResponse signUpResponse = new SignUpResponse();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("password", user.getPassword());
        try {
            int val = jdbcTemplate.update(INSERTUSER, mapSqlParameterSource);
            if (val > 0) {
                signUpResponse.setStatus("S");
                signUpResponse.setMessage("User added successfully");
            }
        } catch (DataIntegrityViolationException e) {
            signUpResponse.setStatus("E");
            signUpResponse.setMessage("User already exists");
        }
        return signUpResponse;
    }

    public SignUpResponse login(User user){

        SignUpResponse signUpResponse = new SignUpResponse();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("password", user.getPassword());
        try {
            String email = jdbcTemplate.queryForObject(FINDUSER, mapSqlParameterSource, String.class);
            if(email != null){
                signUpResponse.setStatus("S");
                signUpResponse.setMessage("Login Successful");
            }
        }catch (IncorrectResultSizeDataAccessException e){
            signUpResponse.setStatus("E");
            signUpResponse.setMessage("Incorrect email/password");
        }

        return signUpResponse;
    }
}
