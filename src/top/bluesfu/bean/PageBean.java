package top.bluesfu.bean;

import java.util.List;

public class PageBean<T> {
    private int currentPage=1;
    private int pageCount=10;
    private int totalCount;
    private int totaPage;



    private List<T> pageData;
    public int getTotaPage() {
        return ((totaPage%pageCount==0)?(totaPage/pageCount):(totaPage/pageCount)+1);
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public void setTotaPage(int totaPage) {
        this.totaPage = totaPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
