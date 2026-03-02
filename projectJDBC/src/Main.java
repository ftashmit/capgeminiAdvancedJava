import  java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Connection conn=DatabaseConfig.getConnection();

        PreparedStatement pstmt=conn.
                prepareStatement("INSERT INTO tasks (title, description) VALUES (?,?)");

        pstmt.setString(1,"JDBC TESTING");
        pstmt.setString(2,"This is JDBC Testing Description");
        pstmt.executeUpdate();

        System.out.println("Successfully inserted tasks");
        pstmt.close();
        conn.close();
    }
}
