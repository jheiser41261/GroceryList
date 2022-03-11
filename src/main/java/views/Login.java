package views;

import models.User;
import services.UserService;

import java.util.Scanner;

public class Login {
    public static void view(){
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-------- LOG IN --------");
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = userService.validateCredentials(username, password);

        if(user == null){
            System.out.println("\nUSERNAME OR PASSWORD IS INCORRECT");
        } else{
            Dashboard.view(user);
        }
    }
}
