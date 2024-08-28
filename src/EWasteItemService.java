import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EWasteItemService {
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/e_waste_management";
        String user = "root"; // replace with your MySQL username
        String password = "dhruvdiya1"; // replace with your MySQL password

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addEWasteItem(EWasteItem item) {
        String sql = "INSERT INTO ewaste_items(name, type, item_condition) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getType());
            pstmt.setString(3, item.getItemCondition());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<EWasteItem> getAllEWasteItems() {
        String sql = "SELECT * FROM ewaste_items";
        List<EWasteItem> items = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EWasteItem item = new EWasteItem(rs.getInt("id"), rs.getString("name"),
                        rs.getString("type"), rs.getString("item_condition"));
                items.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public EWasteItem getEWasteItemById(int id) {
        String sql = "SELECT * FROM ewaste_items WHERE id = ?";
        EWasteItem item = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    item = new EWasteItem(rs.getInt("id"), rs.getString("name"),
                            rs.getString("type"), rs.getString("item_condition"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    public void updateEWasteItem(EWasteItem item) {
        String sql = "UPDATE ewaste_items SET name = ?, type = ?, item_condition = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getType());
            pstmt.setString(3, item.getItemCondition());
            pstmt.setInt(4, item.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEWasteItem(int id) {
        String sql = "DELETE FROM ewaste_items WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
