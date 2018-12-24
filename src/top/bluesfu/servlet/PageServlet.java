package top.bluesfu.servlet;

import top.bluesfu.dao.ProductDao;
import top.bluesfu.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author fsy
 */
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {

        ProductDao productDao=new ProductDao();
           int pageSize=10;
           int pageNow=0;
           int rowCount=productDao.countProduct();

           String getPageNow=httpServletRequest.getParameter("pageNow");
           if (getPageNow!=null){
               pageNow=Integer.parseInt(getPageNow);
           }
           if (pageNow<=1){
               pageNow=1;
           }
           int pageCount =(rowCount%pageSize==0)?(rowCount/pageNow):(rowCount/pageSize)+1;
           if (pageNow>pageCount){
               pageNow=pageCount;
           }



        List<Product> productList=productDao.findAll();
        httpServletRequest.setAttribute("productList",productList);
        httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
