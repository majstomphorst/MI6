//package main.ma.maxim;
//
//import java.sql.*;
//
//public class Database {
//
//    Connection conn = null;
//
//    public Database() {
//        createConnection();
//    }
//
//    private void createConnection() {
//        try {
//            // db parameters
//            String url = "jdbc:mysql://localhost:8889/MI6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            String user = "root";
//            String password = "root";
//
//            // create a connection to the database
//            conn = DriverManager.getConnection(url, user, password);
//            // more processing here
//            // ...
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    /*
//     *if user return user info else null
//     */
//    //todo find user by id
//    public User findUserById(Integer id) {
//
//        User result = new User();
//        String sql = "SELECT * FROM USERS WHERE id = ?";
//
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                result = new User(
//                        rs.getInt("id"),
//                        rs.getString("secret"),
//                        rs.getBoolean("active"),
//                        rs.getDate("licence")
//                );
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//
//    }
//
//}
