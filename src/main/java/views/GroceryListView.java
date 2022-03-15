package views;

import models.GroceryItem;
import models.GroceryList;
import services.GroceryItemService;
import services.GroceryListService;
import util.Print;

import java.util.Scanner;

public class GroceryListView {
    public static void view(Integer listId){
        GroceryListService groceryListService = new GroceryListService();
        GroceryItemService groceryItemService = new GroceryItemService();
        GroceryList groceryList = groceryListService.getOneList(listId);

        Scanner sc = new Scanner(System.in);
        Boolean running = true;

        while(running){
            Print.currentList(groceryList);
            String input = sc.nextLine();

            switch(input){
                case "1":
                    System.out.println(groceryItemService.getAllItemsGivenListId(groceryList.getId()));
                    break;
                case "2":
                    GroceryItem gi = new GroceryItem();
                    System.out.print("Item Name: ");
                    gi.setItemName(sc.nextLine());

                    System.out.print("Quantity: ");
                    String quantity = sc.nextLine();

                    if(!quantity.equals("N")){
                        gi.setItemQuantity(Integer.parseInt(quantity));
                    }

                    gi.setListId(groceryList.getId());

                    groceryItemService.createItem(gi);
                    System.out.println("Item was added to list " + groceryList.getListName());

                    break;
                case "3":
                    System.out.println(groceryItemService.getAllItemsGivenListId(groceryList.getId()));
                    System.out.print("Item ID: ");

                    String itemId = sc.nextLine();

                    groceryItemService.markItemInCart(Integer.parseInt(itemId));
                    System.out.println("Item #" + itemId + " is now in the cart");
                    break;
                case "4":
                    System.out.println(groceryItemService.getAllItemsGivenListId(groceryList.getId()));
                    System.out.print("Item ID: ");

                    String itId = sc.nextLine();

                    groceryItemService.deleteItemFromCart(Integer.parseInt(itId));
                    System.out.println("Item #" + itId + " has been deleted");
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
