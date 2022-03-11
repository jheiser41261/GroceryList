package services;

import models.User;
import repository.UserDAO;
import repository.UserDAOImpl;

public class UserService {
    private UserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDAOImpl();
    }

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User validateCredentials(String username, String password){
        User user = this.userDAO.getUserGivenUsername(username);

        //User wasn't found
        if(user == null)
            return null;

        //Password was incorrect
        if(!password.equals(user.getPassword()))
            return null;

        return user;
    }

    public void createUser(User user){
        this.userDAO.createUser(user);
    }
}
