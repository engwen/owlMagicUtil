package com.owl.magicUtil.dto;

/**
 * 本類使用于查詢 dao 接口，爲了方便并行 sql ，因此使用本封裝
 * @author engwen
 * email xiachanzou@outlook.com
 * 2019/1/3.
 */
public class SelectLikeDTO<T> {
    private T model;
    private Integer upLimit;
    private Integer rows;

    public static <T> SelectLikeDTO<T> getInstance(T model) {
        return new SelectLikeDTO<>(model);
    }

    public static <T> SelectLikeDTO<T> getInstance(T model, Integer upLimit, Integer rows) {
        return new SelectLikeDTO<>(model, upLimit, rows);
    }

    private SelectLikeDTO(T model) {
        this.model = model;
    }

    private SelectLikeDTO(T model, Integer upLimit, Integer rows) {
        this.model = model;
        this.upLimit = upLimit;
        this.rows = rows;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Integer getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(Integer upLimit) {
        this.upLimit = upLimit;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
