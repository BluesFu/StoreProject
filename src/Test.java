import top.bluesfu.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class Test {
    public static void main(String []args){

        System.out.println(DateFormat.getDateInstance().format(new Date()));
        System.out.println(new Date().toLocaleString());
        System.out.println(new Date().toString());
        try {
            Connection conn= JdbcUtils.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
