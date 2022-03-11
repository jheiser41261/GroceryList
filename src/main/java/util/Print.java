package util;

import models.GroceryList;
import models.User;

public class Print {
    public static void landing(){
        System.out.println("\n-------- MAIN MENU --------");
        System.out.println("\n1) Login");
        System.out.println("2) Register\n");
        System.out.println("0) Exit\n");
        System.out.print("> ");
    }

    public static void dashboard(User user){
        System.out.println("\n-------- DASHBOARD --------");
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
        System.out.println("\n1) Display all Lists for " + user.getFirstName());
        System.out.println("2) Open a specific List");
        System.out.println("3) Create a new List");
        System.out.println("4) Delete a List\n");
        System.out.println("0) Log Out\n");
        System.out.print("> ");
    }

    public static void currentList(GroceryList groceryList){
        System.out.println("\n-------- " + groceryList.getListName().toUpperCase() + " --------");
        System.out.println("\n1) Display all items");
        System.out.println("2) Add item");
        System.out.println("3) Mark item in cart");
        System.out.println("4) Delete item\n");
        System.out.println("0) Back to Lists\n");
        System.out.print("> ");
    }
}
