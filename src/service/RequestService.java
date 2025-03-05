package service;

import model.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestService {
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

    public void addRequest(Request request) {
        String sql = "INSERT INTO requests(user_id, item_id, status) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, request.getUserId());
            pstmt.setInt(2, request.getItemId());
            pstmt.setString(3, request.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Request> getAllRequests() {
        String sql = "SELECT * FROM requests";
        List<Request> requests = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Request request = new Request(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getInt("item_id"), rs.getString("status"));
                requests.add(request);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return requests;
    }

    public Request getRequestById(int id) {
        String sql = "SELECT * FROM requests WHERE id = ?";
        Request request = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    request = new Request(rs.getInt("id"), rs.getInt("user_id"),
                            rs.getInt("item_id"), rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return request;
    }

    public void updateRequest(Request request) {
        String sql = "UPDATE requests SET user_id = ?, item_id = ?, status = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, request.getUserId());
            pstmt.setInt(2, request.getItemId());
            pstmt.setString(3, request.getStatus());
            pstmt.setInt(4, request.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteRequest(int id) {
        String sql = "DELETE FROM requests WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
