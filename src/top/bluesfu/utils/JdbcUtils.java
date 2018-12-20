package top.bluesfu.utils;

import java.sql.*;

/**
 * @author fsy
 */
public class JdbcUtils {
    private  JdbcUtils(){}

    /**
     * 驱动注册
     */
    static {
        try {
            Class.forName(PropertiesUtils.getDiverProperties());
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 获取Connection
     * @return connection
     * @throws SQLException
     */
   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(PropertiesUtils.getUrlProperties(),
               PropertiesUtils.getUserNameProperties(), PropertiesUtils.getPasswordProperties());
}



  public static void colseResource(Connection conn, Statement st, ResultSet rs){
       closeResultSet(rs);
       closeStatement(st);
       closeConnection(conn);
  }
  public static void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        conn=null;
  }
  public static void closeStatement(Statement st){
        if (st!=null){
            try {
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
      st=null;
  }

  public static void closeResultSet(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
  }
}
