package services;

import models.GroceryItem;
import repository.GroceryItemDAO;
import repository.GroceryItemDAOImpl;

import java.util.List;

public class GroceryItemService {
    private GroceryItemDAO groceryItemDAO;

    public GroceryItemService(){
        this.groceryItemDAO = new GroceryItemDAOImpl();
    }

    public GroceryItemService(GroceryItemDAO groceryItemDAO){
        this.groceryItemDAO = groceryItemDAO;
    }

    public List<GroceryItem> getAllItemsGivenListId(Integer listId){
        return this.groceryItemDAO.getAllItemsGivenListId(listId);
    }

    public void markItemInCart(Integer itemId){
        this.groceryItemDAO.markItemInCart(itemId);
    }

    public void deleteItemFromCart(Integer itemId){
        this.groceryItemDAO.deleteItemFromList(itemId);
    }

    public void createItem(GroceryItem groceryItem){
        if(groceryItem.getItemQuantity() == null){
            this.groceryItemDAO.createItemForListWithoutQuantity(groceryItem);
        } else {
            this.groceryItemDAO.createItemForListWithQuantity(groceryItem);
        }
    }
}
