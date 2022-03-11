package views;

import models.User;
import services.UserService;

import java.util.Scanner;

public class Register {
    public static void view(){
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-------- REGISTER --------");
        System.out.print("\nUsername: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        userService.createUser(new User(username, password, firstName, lastName));
    }
}
