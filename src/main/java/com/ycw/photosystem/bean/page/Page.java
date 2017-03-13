package com.ycw.photosystem.bean.page;

import java.util.List;

public class Page {
    private int currentPage;
    private static int pageSize;
    private int categoryId;
    private int departmentId;
    private boolean descOrder;
    private List ids;

    public Page() {
        currentPage = 1;
        pageSize = 6;
        categoryId = -1;
        departmentId = -1;
        descOrder = false;
        ids = null;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        Page.pageSize = pageSize;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public boolean isDescOrder() {
        return descOrder;
    }

    public void setDescOrder(boolean descOrder) {
        this.descOrder = descOrder;
    }

    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }
}
