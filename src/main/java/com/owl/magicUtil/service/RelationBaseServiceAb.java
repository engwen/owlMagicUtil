package com.owl.magicUtil.service;

import com.owl.magicUtil.exception.CellBaseException;
import com.owl.magicUtil.model.ModelPrototype;
import com.owl.magicUtil.vo.MsgResultVO;

import java.util.List;
import java.util.logging.Logger;

/**
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/04/22.
 */
public abstract class RelationBaseServiceAb<T> implements RelationBaseService<T> {
    private static Logger logger = Logger.getLogger(RelationBaseServiceAb.class.getName());

    private static void loggerInfo() {
        logger.info("默认的原始输出，将不会产生任何影响");
    }

    /**
     * 插入關係數據
     * @param model 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO insert(T model) throws Exception {
        loggerInfo();
        throw new CellBaseException();
    }

    /**
     * 批量插入
     * @param modelList 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO insertList(List<T> modelList) throws Exception {
        loggerInfo();
        throw new CellBaseException();
    }

    /**
     * 刪除關係數據
     * @param model 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO delete(T model) throws Exception {
        loggerInfo();
        throw new CellBaseException();
    }

    /**
     * 批量刪除
     * @param modelList 汎型對象
     * @return 基礎數據
     * @throws Exception
     */
    @Override
    public MsgResultVO deleteList(List<T> modelList) throws Exception {
        loggerInfo();
        throw new CellBaseException();
    }
}
