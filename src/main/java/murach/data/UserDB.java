package murach.data;

import java.sql.*;
import murach.business.User;

public class UserDB {
    // Cấu hình DB (m sửa lại user/pass cho đúng PostgreSQL của m)
    private static final String URL = "jdbc:postgresql://localhost:5432/email_listt";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    public static void insert(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
        try {
            // Kết nối tới DB
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());

            ps.executeUpdate();

            ps.close();
            conn.close();
            System.out.println("User saved: " + user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}