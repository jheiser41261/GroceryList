package services;

import models.GroceryList;
import repository.GroceryListDAO;
import repository.GroceryListDAOImpl;

import java.util.List;

public class GroceryListService {
    private GroceryListDAO groceryListDAO;

    public GroceryListService(){
        this.groceryListDAO = new GroceryListDAOImpl();
    }

    public GroceryListService(GroceryListDAO groceryListDAO){
        this.groceryListDAO = groceryListDAO;
    }

    public List<GroceryList> getAllListsGivenUserId(Integer userId){
        return this.groceryListDAO.getAllListsGivenUserId(userId);
    }

    public void createList(GroceryList groceryList){
        this.groceryListDAO.createList(groceryList);
    }

    public void deleteList(Integer listId){
        this.groceryListDAO.deleteList(listId);
    }
}
