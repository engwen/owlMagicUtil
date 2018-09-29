package com.owl.magicUtil.service;

import com.owl.magicUtil.exception.CellBaseException;
import com.owl.magicUtil.model.ModelPrototype;
import com.owl.magicUtil.vo.MsgResultVO;
import com.owl.magicUtil.vo.PageVO;

import java.util.List;
import java.util.logging.Logger;

/**
 * 不可實例化，繼承者需要自己實現其中的方法，支持自定義以及添加方法
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/04/22.
 */
public abstract class CellBaseServiceAb<T extends ModelPrototype> implements CellBaseService<T> {
    private static Logger logger = Logger.getLogger(CellBaseServiceAb.class.getName());

    private static void loggerInfo() {
        logger.info("默认的原始输出，将不会产生任何影响");
    }

    /**
     * 創建
     * @param model 汎型對象
     * @return 汎型對象
     * @throws Exception
     */
    @Override
    public MsgResultVO<T> create(T model) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 批量創建
     * @param modelList 汎型對象
     * @return 汎型對象
     * @throws Exception
     */
    @Override
    public MsgResultVO createList(List<T> modelList) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param id 对象ID
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO delete(Long id) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param model 对象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO delete(T model) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 批量刪除 更新前需要查询，因此可能返回对象为父类型
     * @param idList ID集合
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO deleteList(List<Long> idList) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 批量操作 禁用或啓用
     * @param id     對象ID
     * @param status 對象狀態，可以爲空
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO banOrLeave(Long id, Boolean status) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 批量操作 禁用或啓用
     * @param idList 對象ID
     * @param status 對象狀態
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO banOrLeaveList(List<Long> idList, Boolean status) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 更新 更新前需要查询，因此可能返回对象为父类型
     * @param model 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO<T> update(T model) throws Exception {
        throw new CellBaseException();
    }

    /**
     * 獲取詳情
     * @param model 汎型對象檢索條件
     * @return 汎型對象
     */
    @Override
    public MsgResultVO<T> details(T model) {
        loggerInfo();
        return null;
    }

    /**
     * 獲取詳情
     * @param id 汎型對象檢索條件
     * @return 汎型對象
     */
    @Override
    public MsgResultVO<T> details(Long id) {
        loggerInfo();
        return null;
    }

    /**
     * 獲取分頁列表，添加 model 提供檢索功能
     * @param getAll      是否獲取所有
     * @param requestPage 請求頁數
     * @param rows        請求列表的尺寸
     * @param model       檢索條件
     * @return 分頁對象
     */
    @Override
    public MsgResultVO<PageVO<T>> list(Boolean getAll, Integer requestPage, Integer rows, T model) {
        loggerInfo();
        return null;
    }

    /**
     * 獲取所有的對象 添加 model 提供檢索功能
     * @param model 檢索條件
     * @return 對象集合
     */
    @Override
    public MsgResultVO<List<T>> listAll(T model) {
        loggerInfo();
        return null;
    }

    /**
     * 獲取所有的對象
     * @return 對象集合
     */
    @Override
    public MsgResultVO<List<T>> listAll() {
        loggerInfo();
        return null;
    }

    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */
    @Override
    public MsgResultVO isExist(T model) {
        loggerInfo();
        return null;
    }

    /**
     * 檢查数据是否存在
     * @param id id属性
     * @return Boolean
     */
    @Override
    public MsgResultVO isExist(Long id) {
        loggerInfo();
        return null;
    }
}
