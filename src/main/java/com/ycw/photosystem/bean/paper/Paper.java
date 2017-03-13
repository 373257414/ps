package com.ycw.photosystem.bean.paper;

import java.util.List;

public class Paper {
    private int currentPaper;
    private static int paperSize;
    private int categoryId;
    private int departmentId;
    private boolean descOrder;
    private List ids;

    public Paper() {
        currentPaper = 1;
        paperSize = 6;
        categoryId = -1;
        departmentId = -1;
        descOrder = false;
        ids = null;
    }

    public int getCurrentPaper() {
        return currentPaper;
    }

    public void setCurrentPaper(int currentPaper) {
        this.currentPaper = currentPaper;
    }

    public int getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(int paperSize) {
        this.paperSize = paperSize;
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
