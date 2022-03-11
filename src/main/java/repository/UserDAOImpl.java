package repository;

import models.User;
import util.ConnectionUtil;

import java.sql.*;

/*
* What is needed to connect to our PostGreSQL database on AWS using JDBC?
* - URL (location of our database)
*       - Syntax: "jdbc:postgresql://[AWS Endpoint]/[Database]"
* - Username for our AWS database
* - Password for our AWS database
* - Driver
*
* Interfaces and classes of JDBC:
* - Connection (interface): The active connection with the database
* - DriverManager: Retrieves the connection from our database
* - Statement: Object representation of the SQL statement
*       - PreparedStatement: A Statement that prevents SQL injection
* - ResultSet: Object representation of the result set
*
* The most common error connecting to JDBC is:
* - No suitable driver found, meaning either:
*       - You don't have the driver
*       - The URL string is incorrect
* */

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserGivenUsername(String username) {
        User user = null;

        //DQL STATEMENT
        try(Connection conn = ConnectionUtil.getConnection()){
            //'try' retrieves active connection from our database

            String sql = "SELECT * FROM users WHERE user_name = ?;";

            //Preparing our SQL statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //We are adding the username into the question mark in 'sql'
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getTimestamp(6)
                        );
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user) {

        //DML STATEMENT
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO users (user_name, user_pass, user_fname, user_lname) VALUES (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());

            ps.executeUpdate();

        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
