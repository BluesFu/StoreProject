package top.bluesfu.dao;

import top.bluesfu.model.User;
import top.bluesfu.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author fsy
 */
public class UserDao {
    public int addUser(User user){
        int num;
        String sql="insert into user(username,password,email,regsitTime)"+"values(?,?,?,?)";

        try {
            Connection conn=JdbcUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,DateFormat.getDateInstance().format(new Date()));

            num=ps.executeUpdate();
           JdbcUtils.closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        return 0;
        }
         return num;
    }






/*

    public int addUser(String name,String password,String email) {
   int num;
   String sql="insert into user(username,password,email,regsitsTime)"+"values(?,?,?,?)";
   try{
       Connection conn= JdbcUtils.getConnection();
       PreparedStatement stmt=conn.prepareStatement(sql);
       stmt.setString(1,name);
       stmt.setString(2,password);
       stmt.setString(3,email);
       stmt.setString(4,DateFormat.getDateInstance().format(new Date()) );
       num=stmt.executeUpdate();
   }catch (Exception e){
       return 0;
   }
   return num;
    }

    public int deleteUser(int id) {
        int count=0;

        try {
            Connection conn=JdbcUtils.getConnection();
            String sql="delete from user where id="+id;
            Statement st=conn.createStatement();
            count=st.executeUpdate(sql);
            if (count!=0){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public int updateUser(){
        return 0;
    }*/

}
