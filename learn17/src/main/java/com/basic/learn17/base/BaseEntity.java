package com.basic.learn17.base;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    /**
     * 分页页码，默认 1
     */
    int page = 1;
    /**
     * 分页每页数量，默认 5
     */
    int size = 5;
    /**
     * 排序列名称，默认 id
     */
    String selectId = "id";
    /**
     * 排序方式，默认增序
     */
    String sort = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
