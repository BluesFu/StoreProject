package top.bluesfu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import top.bluesfu.bean.PageBean;
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
        String sql="insert into products(name,price,category,pnum,imgurl,description)"+"values(?,?,?,?,?,?)";
   int num=0;
   Object[] params={product.getName(),product.getPrice(),product.getCategory(),product.getPnum(),product.getImgurl(),product.getDescription()};
        try {
            num=qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void findAll(PageBean<Product> productPageBean){
        int totalCount=this.getTotalCount();
        productPageBean.setTotalCount(totalCount);

        if (productPageBean.getCurrentPage()<0){
            productPageBean.setCurrentPage(1);
        }else if (productPageBean.getCurrentPage()>productPageBean.getTotalCount()){
            productPageBean.setCurrentPage(productPageBean.getTotaPage());
        }

        int currentPage=productPageBean.getCurrentPage();
        int index=(currentPage-1)*productPageBean.getPageCount();
        int count=productPageBean.getPageCount();

        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM products LIMIT ?,?";
        try {
            List<Product> pageData=qr.query(sql,new BeanListHandler<Product>(Product.class),index,count);
            productPageBean.setPageData(pageData);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getTotalCount(){
        String sql="SELCET COUNT(*) FROM products";

        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Long count=qr.query(sql,new ScalarHandler<Long>());
            return count.intValue();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }


}
