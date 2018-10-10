package com.owl.magicUtil.util;

import com.owl.magicUtil.constant.MsgConstantEM;
import com.owl.magicUtil.dao.CellBaseDao;
import com.owl.magicUtil.dao.RelationBaseDao;
import com.owl.magicUtil.vo.MsgResultVO;

import java.util.List;

/**
 * 類適用于常見的方法，提供基礎解決方案，繼承service類之後，可在注入dao后使用本工具類快速完成基礎功能代碼
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/10/10.
 */
public abstract class RelationBaseServiceUtil {
    /**
     * 插入關係數據
     * @param model 汎型對象
     * @return 基礎數據
     */
    public static <T> MsgResultVO insert(RelationBaseDao<T> relationBaseDao, T model) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            List<T> temp = relationBaseDao.selectBySelective(model);
            if (null != temp && temp.size() > 0) {
                resultVO.errorResult(MsgConstantEM.REQUEST_IS_EXITS);
            } else {
                if (relationBaseDao.insert(model) > 0) {
                    resultVO.successResult();
                } else {
                    resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
                }
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量插入
     * @param modelList 汎型對象
     * @return 基礎數據
     */
    public static <T> MsgResultVO insertList(RelationBaseDao<T> relationBaseDao, List<T> modelList) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            relationBaseDao.insertList(modelList);
            resultVO.successResult();
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 刪除關係數據
     * @param model 汎型對象
     * @return 基礎數據
     */
    public static <T> MsgResultVO delete(RelationBaseDao<T> relationBaseDao, T model) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            relationBaseDao.delete(model);
            resultVO.successResult();
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量刪除
     * @param modelList 汎型對象
     * @return 基礎數據
     */
    public static <T> MsgResultVO deleteList(RelationBaseDao<T> relationBaseDao, List<T> modelList) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            relationBaseDao.deleteList(modelList);
            resultVO.successResult();
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }
}
