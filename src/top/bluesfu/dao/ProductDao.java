package top.bluesfu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import top.bluesfu.model.Product;
import top.bluesfu.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fsy
 */
public class ProductDao {
    public int addProduct(Product product){
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into products(name,price,category,pnum,imgurl,description)";
   int num=0;
   Object[] params={product.getName(),product.getPrice(),product.getCategory(),product.getPnum(),product.getImgurl(),product.getDescription()};
        try {
            num=qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public List findAll(){
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM products";
        try {
            List list=qr.query(sql,new BeanListHandler<Product>(Product.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
           return null;
    }
      public int countProduct(){
           QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
           String sql="SELECT COUNT(*) FROM products";
           int count=0;
          try {
                  count=qr.query(sql,new ScalarHandler<Integer>());
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return count;
      }



}
