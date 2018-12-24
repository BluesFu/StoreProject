
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.bluesfu.model.User;
import top.bluesfu.utils.DataSourceUtils;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;




public class Test {
    public static void main(String []args) {

        System.out.println(DateFormat.getDateInstance().format(new Date()));
        System.out.println(new Date().toLocaleString());
        System.out.println(new Date().toString());
        System.out.println(DataSourceUtils.getDataSource());

        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM user";
            try {
            Iterator<User> users =  qr.query(sql, new BeanListHandler<User>(User.class)).iterator();
                while (users.hasNext()) {
                   User user=users.next();
                   System.out.println(user.getId()+user.getUsername()+user.getPassword()+user.getPassword()+user.getEmail());

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }