package com.app.pagination.PaginationSortingProject.model;

public enum OrderBy {
    ID("id"),
    USERID("userId");

    private String OrderByCode;
    private OrderBy(String orderBy) {
        this.OrderByCode = orderBy;
    }
    public String getOrderByCode() {
        return this.OrderByCode;
    }
}
