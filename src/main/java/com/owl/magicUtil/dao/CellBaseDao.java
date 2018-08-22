package com.owl.magicUtil.dao;

import com.owl.magicUtil.model.MsgResult;

import java.util.List;

/**
 * 底层对dao进行统一，本接口对外开放
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/08/22.
 */
public interface CellBaseDao<T extends MsgResult> {

    /**
     * 直接插入
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 依照屬性插入
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertList(List<T> list);

    /**
     * 刪除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量刪除
     * @param idList
     * @return
     */
    int deleteByIdList(List<Long> idList);

    /**
     * 依據Id更新
     * @param record
     * @return
     */
    int updateById(T record);

    /**
     * 依據指定的屬性進行更新
     * @param record
     * @return
     */
    int updateBySelective(T record);

    /**
     * 依據id查詢對象
     * @param id
     * @return
     */
    T selectById(Long id);

    /**
     * 依據屬性獲取對象集合
     * @param record
     * @return
     */
    List<T> selectBySelective(T record);

    /**
     * 獲取全部
     * @return
     */
    List<T> listAll();

    /**
     * 依據指定的屬性統計數據條數
     * @param record
     * @return
     */
    Integer countSumByCondition(T record);

    /**
     * 依據指定的屬性獲取指定的集合
     * @param upLimit @Param("upLimit")
     * @param rows    @Param("rows")
     * @param record  @Param("record")
     * @return
     */
    List<T> listByCondition(Integer upLimit, Integer rows, T record);

}
