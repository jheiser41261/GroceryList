package services;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    private UserDAO userDAO = Mockito.mock(UserDAO.class);

    public UserServiceTest(){
        this.userService = new UserService(userDAO);
    }

    @Test
    void validateCredentialsInvalidUsername() {
        //Arrange
        String expectedUsername = "incorrectusername";
        String expectedPassword = "pass123";
        User expectedOutput = null;
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        //Act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);

        //Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void validateCredentialsInvalidPassword() {
        //Arrange
        String expectedUsername = "correctusername";
        String expectedPassword = "pass123";
        User expectedOutput = null;
        User userFromDb = new User("correctusername", "pass1234", "New", "User");
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(userFromDb);

        //Act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);

        //Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void validateCredentialsValidCredentials() {
        //Arrange
        String expectedUsername = "correctusername";
        String expectedPassword = "correctpassword";
        User expectedOutput = new User(expectedUsername, expectedPassword, "New", "User");
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        //Act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);

        //Assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createUser() {
        //Arrange
        User userToPass = new User("username", "password", "New", "User");

        //Act
        userService.createUser(userToPass);

        //Assert
        //Mockito.verify() can be used to validate if a method was run
        Mockito.verify(userDAO, Mockito.times(1)).createUser(userToPass);
    }
}