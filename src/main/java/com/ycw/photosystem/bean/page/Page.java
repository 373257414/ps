package com.ycw.photosystem.bean.page;

import java.util.List;
import java.util.Map;

public class Page {
    private int currentPage;
    private int pageSize;
    private int categoryId;
    private int departmentId;
    private boolean descOrder;
    private List ids;
    private Map<String, Object> conditionMap;

    public Page() {
        currentPage = 1;
        pageSize = 6;
        categoryId = -1;
        departmentId = -1;
        descOrder = false;
        ids = null;
        conditionMap = null;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public  int getPageSize() {
        return pageSize;
    }

    public  void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public Map getConditionMap() {
        return conditionMap;
    }

    public void setConditionMap(Map conditionMap) {
        this.conditionMap = conditionMap;
    }
}
