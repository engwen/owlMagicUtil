package com.owl.magicUtil.dao;

import java.util.List;

/**
 * 底层对基礎dao进行统一，本接口对外开放
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/08/22.
 */
public interface CellBaseDao<T> {

    /**
     * 直接插入
     * @param record 泛型对象
     * @return int
     */
    int insert(T record);

    /**
     * 批量插入
     * @param list 泛型对象集合
     * @return int
     */
    int insertList(List<T> list);

    /**
     * 批量刪除
     * @param idList id集合
     * @return int
     */
    int deleteByIdList(List<Long> idList);

    /**
     * 刪除
     * @param model 泛型对象
     * @return int
     */
    int deleteBySelective(T model);

    /**
     * 批量操作 禁用或啓用
     * @param idList 對象ID
     * @param status 對象狀態
     * @return int
     */
    int banOrLeave(List<Long> idList, Boolean status);

    /**
     * 依據指定的屬性進行更新
     * @param record 泛型对象
     * @return int
     */
    int updateBySelective(T record);

    /**
     * 依據屬性獲取對象集合
     * @param record 泛型对象
     * @return 泛型对象集合
     */
    List<T> selectBySelective(T record);

    /**
     * 依據指定的屬性統計數據條數
     * @param record 泛型对象
     * @return int
     */
    Integer countSumByCondition(T record);

    /**
     * 依據指定的屬性獲取指定的集合
     *
     * @param upLimit Param("upLimit")
     * @param rows    Param("rows")
     * @param record  Param("record")
     * @return 泛型对象集合
     */
    List<T> listByCondition(Integer upLimit, Integer rows, T record);

}
