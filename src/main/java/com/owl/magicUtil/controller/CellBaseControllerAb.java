package com.owl.magicUtil.controller;

import com.owl.magicUtil.constant.MsgConstantUtil;
import com.owl.magicUtil.model.MsgResult;
import com.owl.magicUtil.vo.MsgResultVO;
import com.owl.magicUtil.vo.PageVO;

import java.util.List;
import java.util.logging.Logger;

/**
 * 本类可用于Controller的集成，定义了常用的部分功能，继承本类后实现即可
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/07/16.
 */
public abstract class CellBaseControllerAb<T extends MsgResult> implements CellBaseController<T> {
    private static Logger logger = Logger.getLogger(CellBaseControllerAb.class.getName());

    private static void LoggerInfo() {
        logger.info("默认的原始输出，将不会产生任何影响");
    }

    /**
     * 创建
     * @param model 将要被创建的对象
     * @return 创建后的对象返回数据
     */
    @Override
    public MsgResult create(T model) {
        LoggerInfo();
        model.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return model;
    }

    /**
     * 批量创建
     * @param list 待创建对象集合
     * @return 结果
     */
    @Override
    public MsgResult createList(List<T> list) {
        LoggerInfo();
        MsgResult result = new MsgResultVO();
        result.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return result;
    }

    /**
     * 删除功能
     * @param model 待删除的对象
     * @return 结果
     */
    @Override
    public MsgResult delete(T model) {
        LoggerInfo();
        MsgResult result = new MsgResultVO();
        result.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return result;
    }

    /**
     * 批量删除
     * @param idList 待删除的id集合
     * @return 结果
     */
    @Override
    public MsgResult deleteList(List<Long> idList) {
        LoggerInfo();
        MsgResult result = new MsgResultVO();
        result.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return result;
    }

    /**
     * 更新
     * @param model 将要被更新的对象
     * @return 结果
     */
    @Override
    public MsgResult update(T model) {
        LoggerInfo();
        MsgResult result = new MsgResultVO();
        result.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return result;
    }

    /**
     * 获取详情
     * @param model 获取详情的对象唯一属性
     * @return 结果对象
     */
    @Override
    public MsgResult details(T model) {
        LoggerInfo();
        model.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return model;
    }

    /**
     * 获取分页集合
     * @param requestPage 请求页数
     * @param size        请求显示条数
     * @param model       检索对象属性
     * @return 分页集合
     */
    @Override
    public PageVO<T> list(Integer requestPage, Integer size, T model) {
        LoggerInfo();
        PageVO<T> pageVO = new PageVO<>();
        pageVO.errorResult(MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_CODE, MsgConstantUtil.REQUEST_METHOD_NOT_EXITS_ERROR_MSG);
        return pageVO;
    }

    /**
     * 获取所有对象
     * @param model 检索条件
     * @return 结果集合
     */
    @Override
    public List<T> listAll(T model) {
        LoggerInfo();
        return null;
    }

    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */
    @Override
    public MsgResult isExist(T model) {
        LoggerInfo();
        return null;
    }
}
