package models;

public class GroceryList {
    private Integer id;
    private String listName;
    private Integer userId;

    public GroceryList() {
    }

    public GroceryList(String listName, Integer userId) {
        this.listName = listName;
        this.userId = userId;
    }

    public GroceryList(Integer id, String listName, Integer userId) {
        this.id = id;
        this.listName = listName;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", listName='" + listName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
