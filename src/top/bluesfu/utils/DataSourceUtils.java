package top.bluesfu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;



/**
 * @author fsy
 */
public class DataSourceUtils {

    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }


}
