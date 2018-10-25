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
     * 獲取關係詳情集合
     * @param model 泛型对象
     * @return 泛型对象集合
     */
    List<T> selectBySelective(T model);

    /**
     * 插入關係數據
     * @param model 汎型對象
     * @return int
     */
    int insert(T model);

    /**
     * 批量插入
     * @param modelList 汎型對象
     * @return int
     */
    int insertList(List<T> modelList);

    /**
     * 刪除關係數據
     * @param model 汎型對象
     * @return int
     */
    int delete(T model);

    /**
     * 批量刪除
     * @param modelList 汎型對象
     * @return int
     */
    int deleteList(List<T> modelList);

}
