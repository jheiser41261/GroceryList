package repository;

import models.GroceryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryItemDAOImpl implements GroceryItemDAO {
    String url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/grocerylist";
    String username = System.getenv("AWS_RDS_USERNAME");
    String password = System.getenv("AWS_RDS_PASS");

    @Override
    public List<GroceryItem> getAllItemsGivenListId(Integer listId) {
        List<GroceryItem> items = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);){
            String sql = "SELECT * FROM grocery_item WHERE grocery_list_id_fk = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, listId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                items.add (new GroceryItem(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBoolean(4),
                        rs.getInt(5)
                ));
            }
        } catch(SQLException sqle){
            sqle.printStackTrace();
        }

        return items;
    }

    @Override
    public void markItemInCart(Integer itemId) {
        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);){
            String sql = "UPDATE grocery_item SET item_in_cart = TRUE WHERE item_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, itemId);

            ps.executeUpdate();

        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void createItemForListWithQuantity(GroceryItem item) {
        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);){
            String sql = "INSERT INTO grocery_item (item_name, item_quantity, grocery_list_id_fk) VALUES (?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getItemQuantity());
            ps.setInt(3, item.getListId());

            ps.executeUpdate();

        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void createItemForListWithoutQuantity(GroceryItem item) {
        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);){
            String sql = "INSERT INTO grocery_item (item_name, grocery_list_id_fk) VALUES (?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getListId());

            ps.executeUpdate();

        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteItemFromList(Integer itemId) {
        try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password);){
            String sql = "DELETE FROM grocery_item WHERE item_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, itemId);

            ps.executeUpdate();

        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
