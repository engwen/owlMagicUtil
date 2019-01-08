package com.owl.magicUtil.dao;

import java.util.List;

/**
 * 關係數據類型dao，本接口對外開發
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/10/10.
 */
public interface RelationBaseDao<T> {

    /**
     * 批量插入
     * @param modelList 汎型對象
     * @return int
     */
    int insertList(List<T> modelList);

    /**
     * 批量刪除
     * @param modelList 汎型對象
     * @return int
     */
    int deleteList(List<T> modelList);
}
