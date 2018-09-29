package com.owl.magicUtil.service;

import com.owl.magicUtil.model.ModelPrototype;
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
interface CellBaseService<T extends ModelPrototype> {
    /**
     * 創建
     * @param model 汎型對象
     * @return 汎型對象
     * @throws Exception
     */
    MsgResultVO<T> create(T model) throws Exception;

    /**
     * 批量創建
     * @param modelList 汎型對象
     * @return 汎型對象
     * @throws Exception
     */
    MsgResultVO createList(List<T> modelList) throws Exception;

    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param id 对象ID
     * @return 基礎數據
     * @throws Exception
     */
    MsgResultVO delete(Long id) throws Exception;

    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param model 对象
     * @return 基礎數據
     * @throws Exception
     */
    MsgResultVO delete(T model) throws Exception;

    /**
     * 批量刪除 更新前需要查询，因此可能返回对象为父类型
     * @param idList ID集合
     * @return 基礎數據
     * @throws Exception
     */
    MsgResultVO deleteList(List<Long> idList) throws Exception;

    /**
     * 批量操作 禁用或啓用
     * @param id     對象ID
     * @param status 對象狀態，可以爲空
     * @return
     * @throws Exception
     */
    MsgResultVO banOrLeave(Long id, Boolean status) throws Exception;

    /**
     * 批量操作 禁用或啓用
     * @param idList 對象ID
     * @param status 對象狀態
     * @return
     * @throws Exception
     */
    MsgResultVO banOrLeaveList(List<Long> idList, Boolean status) throws Exception;

    /**
     * 更新 更新前需要查询，因此可能返回对象为父类型
     * @param model 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    MsgResultVO<T> update(T model) throws Exception;

    /**
     * 獲取詳情
     * @param model 汎型對象檢索條件
     * @return 汎型對象
     */
    MsgResultVO<T> details(T model);

    /**
     * 獲取詳情
     * @param id 汎型對象檢索條件
     * @return 汎型對象
     */
    MsgResultVO<T> details(Long id);

    /**
     * 獲取分頁列表，添加 model 提供檢索功能
     * @param getAll      是否獲取所有
     * @param requestPage 請求頁數
     * @param rows        請求列表的尺寸
     * @param model       檢索條件
     * @return 分頁對象
     */
    MsgResultVO<PageVO<T>> list(Boolean getAll, Integer requestPage, Integer rows, T model);

    /**
     * 獲取所有的對象 添加 model 提供檢索功能
     * @param model 檢索條件
     * @return 對象集合
     */
    MsgResultVO<List<T>> listAll(T model);

    /**
     * 獲取所有的對象
     * @return 對象集合
     */
    MsgResultVO<List<T>> listAll();

    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */
    MsgResultVO isExist(T model);

    /**
     * 檢查数据是否存在
     * @param id id属性
     * @return Boolean
     */
    MsgResultVO isExist(Long id);

}
