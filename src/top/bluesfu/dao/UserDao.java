package top.bluesfu.dao;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.bluesfu.model.User;
import top.bluesfu.utils.DataSourceUtils;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

/**
 * @author fsy
 */
public class UserDao {

    public int addUser(User user){
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into user(username,password,email,regsitTime)"+"values(?,?,?,?)";
        int num=0;
        Object[] params={user.getUsername(),user.getPassword(),user.getEmail(),new Timestamp(Calendar.getInstance().getTimeInMillis())};
        try {
            num= qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }


    public List findAll() {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM user";
        try {
            List list=  qr.query(sql,new BeanListHandler<User>(User.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    


}


