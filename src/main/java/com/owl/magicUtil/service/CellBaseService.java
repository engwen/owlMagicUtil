package com.owl.magicUtil.service;

import com.owl.magicUtil.model.MsgResult;
import com.owl.magicUtil.vo.MsgResultVO;
import com.owl.magicUtil.vo.PageVO;

import java.util.List;

/**
 * 不推薦的使用方式，采取包内策略，详见CellBaseServiceAb类 {@link CellBaseServiceAb}
 * 大多數的默認接口
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/01/22.
 */
interface CellBaseService<T> {
    /**
     * 創建
     * @param model 汎型對象
     * @return 汎型對象
     */
    T create(T model);

    /**
     * 批量創建
     * @param modelList 汎型對象
     * @return 汎型對象
     */
    MsgResult createList(List<T> modelList);

    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param id 对象ID
     * @return 基礎數據
     */
    MsgResult delete(Long id);

    /**
     * 批量刪除 更新前需要查询，因此可能返回对象为父类型
     * @param idList ID集合
     * @return 基礎數據
     */
    MsgResult deleteList(List<Long> idList);

    /**
     * 批量操作 禁用或啓用
     * @param id     對象ID
     * @param status 對象狀態，可以爲空
     * @return
     */
    MsgResult banOrLeave(Long id, Boolean status);

    /**
     * 批量操作 禁用或啓用
     * @param idList 對象ID
     * @param status 對象狀態
     * @return
     */
    MsgResult banOrLeaveList(List<Long> idList, Boolean status);

    /**
     * 更新 更新前需要查询，因此可能返回对象为父类型
     * @param model 汎型對象
     * @return 基礎數據
     */
    MsgResult update(T model);

    /**
     * 獲取詳情
     * @param model 汎型對象檢索條件
     * @return 汎型對象
     */
    T details(T model);

    /**
     * 獲取分頁列表，添加 model 提供檢索功能
     * @param getAll      是否獲取所有
     * @param requestPage 請求頁數
     * @param size        請求列表的尺寸
     * @param model       檢索條件
     * @return 分頁對象
     */
    PageVO<T> list(Boolean getAll, Integer requestPage, Integer size, T model);

    /**
     * 獲取所有的對象 添加 model 提供檢索功能
     * @param model 檢索條件
     * @return 對象集合
     */
    List<T> listAll(T model);
}
