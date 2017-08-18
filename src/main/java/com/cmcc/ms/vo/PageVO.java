package com.cmcc.ms.vo;

/**
 * ClassName:PageVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年5月22日 上午10:09:20 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
public class PageVO {

    private int currentPage;
    private int pageSize;
    private int totalItems;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "PageVO [getCurrentPage()=" + getCurrentPage() + ", getPageSize()=" + getPageSize()
                + ", getTotalItems()=" + getTotalItems() + "]";
    }

}
