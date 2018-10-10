package com.owl.magicUtil.util;

import com.owl.magicUtil.constant.MsgConstantEM;
import com.owl.magicUtil.dao.CellBaseDao;
import com.owl.magicUtil.vo.MsgResultVO;
import com.owl.magicUtil.vo.PageVO;

import java.util.List;

/**
 * 本類適用于常見的方法，提供基礎解決方案，繼承service類之後，可在注入dao后使用本工具類快速完成基礎功能代碼
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/10/09.
 */
public abstract class CellBaseServiceUtil {
    /**
     * 創建
     * @param model 汎型對象
     * @return 汎型對象
     */
    public static <T> MsgResultVO<T> create(CellBaseDao<T> cellBaseDao, T model) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.insert(model) > 0) {
                resultVO.successResult(model);
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量創建
     * @param modelList 汎型對象
     * @return 汎型對象
     */
    public static <T> MsgResultVO createList(CellBaseDao<T> cellBaseDao, List<T> modelList) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.insertList(modelList) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }


    /**
     * 刪除 更新前需要查询，因此可能返回对象为父类型
     * @param model 对象
     * @return 基礎數據
     */
    public static <T> MsgResultVO delete(CellBaseDao<T> cellBaseDao, T model) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.deleteBySelective(model) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量刪除 更新前需要查询，因此可能返回对象为父类型
     * @param idList ID集合
     * @return 基礎數據
     */
    public static <T> MsgResultVO deleteList(CellBaseDao<T> cellBaseDao, List<Long> idList) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.deleteByIdList(idList) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量操作 禁用或啓用
     * @param id     對象ID
     * @param status 對象狀態，可以爲空
     * @return 基礎數據
     */
    public static <T> MsgResultVO banOrLeave(CellBaseDao<T> cellBaseDao, Long id, Boolean status) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.banOrLeave(id, status) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 批量操作 禁用或啓用
     * @param idList 對象ID
     * @param status 對象狀態
     * @return 基礎數據
     */
    public static <T> MsgResultVO banOrLeaveList(CellBaseDao<T> cellBaseDao, List<Long> idList, Boolean status) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.banOrLeaveList(idList, status) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 更新 更新前需要查询，因此可能返回对象为父类型
     * @param model 汎型對象
     * @return 基礎數據
     */
    public static <T> MsgResultVO<T> update(CellBaseDao<T> cellBaseDao, T model) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            if (cellBaseDao.updateBySelective(model) > 0) {
                resultVO.successResult();
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 獲取詳情
     * @param id 汎型對象檢索條件
     * @return 汎型對象
     */

    public static <T> MsgResultVO<T> details(CellBaseDao<T> cellBaseDao, Long id) {
        MsgResultVO<T> resultVO = new MsgResultVO<>();
        try {
            T model = cellBaseDao.selectById(id);
            if (null != model) {
                resultVO.successResult(model);
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_NOT_EXITS);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }


    /**
     * 獲取詳情
     * @param model 汎型對象檢索條件
     * @return 汎型對象
     */

    public static <T> MsgResultVO<List<T>> details(CellBaseDao<T> cellBaseDao, T model) {
        MsgResultVO<List<T>> resultVO = new MsgResultVO<>();
        try {
            resultVO.successResult(cellBaseDao.selectBySelective(model));
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }


    /**
     * 獲取分頁列表，添加 model 提供檢索功能
     * @param getAll      是否獲取所有
     * @param requestPage 請求頁數
     * @param rows        請求列表的尺寸
     * @param model       檢索條件
     * @return 分頁對象
     */

    public static <T> MsgResultVO<PageVO<T>> list(CellBaseDao<T> cellBaseDao, Boolean getAll, Integer requestPage, Integer rows, T model) {
        MsgResultVO<PageVO<T>> resultVO = new MsgResultVO<>();
        try {
            PageVO<T> pageVO = new PageVO<>();
            pageVO.initPageVO(cellBaseDao.countSumByCondition(model), requestPage, rows, getAll);
            pageVO.setObjectList(cellBaseDao.listByCondition(pageVO.getUpLimit(), pageVO.getRows(), model));
            resultVO.successResult(pageVO);
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 獲取所有的對象
     * @return 對象集合
     */

    public static <T> MsgResultVO<List<T>> listAll(CellBaseDao<T> cellBaseDao) {
        MsgResultVO<List<T>> resultVO = new MsgResultVO<>();
        try {
            resultVO.successResult(cellBaseDao.listAll());
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */

    public static <T> MsgResultVO isExist(CellBaseDao<T> cellBaseDao, T model) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            List<T> list = cellBaseDao.selectBySelective(model);
            if (null != list && list.size() > 0) {
                resultVO.successResult(MsgConstantEM.REQUEST_IS_EXITS);
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_NOT_EXITS);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }

    /**
     * 檢查数据是否存在
     * @param id id属性
     * @return Boolean
     */
    public static <T> MsgResultVO isExist(CellBaseDao<T> cellBaseDao, Long id) {
        MsgResultVO resultVO = new MsgResultVO();
        try {
            T model = cellBaseDao.selectById(id);
            if (null != model) {
                resultVO.successResult(MsgConstantEM.REQUEST_IS_EXITS);
            } else {
                resultVO.errorResult(MsgConstantEM.REQUEST_NOT_EXITS);
            }
        } catch (Exception e) {
            resultVO.errorResult(MsgConstantEM.REQUEST_DB_ERROR);
        }
        return resultVO;
    }
}
