package DDT;

import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

/**
 *
 * @author mysqltutorial.org
 */
public class SelectQuery {

    public static void main(String[] args) {
        //
        String sql = "SELECT top 1 * FROM [ebookshop].[dbo].[books]";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getString("TITLE")  + "\t" +
                        rs.getInt("author"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}