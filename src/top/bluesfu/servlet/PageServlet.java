package top.bluesfu.servlet;

import top.bluesfu.bean.PageBean;
import top.bluesfu.dao.ProductDao;
import top.bluesfu.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fsy
 */
public class PageServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    private ProductDao productDao=new ProductDao();
    private String uri;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         try {
             String currPage = request.getParameter("currentPage");

             if (currPage == null || "".equals(currPage.trim())) {
                 currPage = "1";
             }
             int currentPage = Integer.parseInt(currPage);

             PageBean<Product> productPageBean = new PageBean<Product>();
             productPageBean.setCurrentPage(currentPage);
             productDao.findAll(productPageBean);

             request.setAttribute("productPageBean", productPageBean);
             uri = "/index.jsp";
         }catch (Exception e){
             e.printStackTrace();
             uri="/html/error.html";
         }
         request.getRequestDispatcher(uri).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
