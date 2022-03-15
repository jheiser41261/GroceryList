package views;

import models.GroceryList;
import models.User;
import services.GroceryListService;
import util.Print;

import java.util.Scanner;

public class Dashboard {
    public static void view(User user){
        GroceryListService groceryListService = new GroceryListService();
        Scanner sc = new Scanner(System.in);
        Boolean running = true;

        while(running){
            Print.dashboard(user);
            String input = sc.nextLine();

            switch(input){
                case "1":
                    System.out.println(groceryListService.getAllListsGivenUserId(user.getId()));
                    break;
                case "2":
                    System.out.print("List ID: ");
                    String listId = sc.nextLine();

                    if(groceryListService.isListOurs(user, Integer.parseInt(listId))){
                        GroceryListView.view(Integer.parseInt(listId));
                    } else{
                        System.out.println("INVALID INPUT");
                    }

                    break;
                case "3":
                    System.out.print("List Name: ");
                    String name = sc.nextLine();
                    groceryListService.createList(new GroceryList(name, user.getId()));
                    System.out.println("List " + name + " was created");
                    break;
                case "4":
                    System.out.println(groceryListService.getAllListsGivenUserId(user.getId()));
                    System.out.print("List ID: ");
                    String liId = sc.nextLine();
                    groceryListService.deleteList(Integer.parseInt(liId));
                    System.out.println("List number " + liId + " was deleted");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }
}
