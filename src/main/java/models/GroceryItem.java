package models;

public class GroceryItem {
    private Integer id;
    private String itemName;
    private Integer itemQuantity;
    private Boolean itemInCart;
    private Integer listId;

    public GroceryItem() {
    }

    public GroceryItem(String itemName, Integer listId) {
        this.id = id;
        this.itemName = itemName;
        this.listId = listId;
    }

    public GroceryItem(String itemName, Integer itemQuantity, Integer listId) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.listId = listId;
    }

    public GroceryItem(Integer id, String itemName, Integer itemQuantity, Boolean itemInCart, Integer listId) {
        this.id = id;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemInCart = itemInCart;
        this.listId = listId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Boolean getItemInCart() {
        return itemInCart;
    }

    public void setItemInCart(Boolean itemInCart) {
        this.itemInCart = itemInCart;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemInCart=" + itemInCart +
                ", listId=" + listId +
                '}';
    }
}
