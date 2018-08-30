package com.owl.magicUtil.controller;

import com.owl.magicUtil.constant.MsgConstantEM;
import com.owl.magicUtil.model.ModelPrototype;
import com.owl.magicUtil.vo.MsgResultVO;

import java.util.List;
import java.util.logging.Logger;

/**
 * 本类可用于Controller的集成，定义了常用的部分功能，继承本类后实现即可
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/07/16.
 */
public abstract class CellBaseControllerAb<T extends ModelPrototype> implements CellBaseController<T> {
    private static Logger logger = Logger.getLogger(CellBaseControllerAb.class.getName());

    private static MsgResultVO defaultBack() {
        logger.info("默认的原始输出，将不会产生任何影响");
        MsgResultVO result = new MsgResultVO();
        result.errorResult(MsgConstantEM.REQUEST_METHOD_NOT_EXITS);
        return result;
    }

    /**
     * 创建
     * @param model 将要被创建的对象
     * @return 创建后的对象返回数据
     */
    @Override
    public MsgResultVO create(T model) {
        return defaultBack();
    }

    /**
     * 批量创建
     * @param list 待创建对象集合
     * @return 结果
     */
    @Override
    public MsgResultVO createList(List<T> list) {
        return defaultBack();
    }

    /**
     * 删除功能
     * @param model 待删除的对象
     * @return 结果
     */
    @Override
    public MsgResultVO delete(T model) {
        return defaultBack();
    }

    /**
     * 批量删除
     * @param idList 待删除的id集合
     * @return 结果
     */
    @Override
    public MsgResultVO deleteList(List<Long> idList) {
        return defaultBack();
    }

    /**
     * 更新
     * @param model 将要被更新的对象
     * @return 结果
     */
    @Override
    public MsgResultVO update(T model) {
        return defaultBack();
    }

    /**
     * 获取详情
     * @param model 获取详情的对象唯一属性
     * @return 结果对象
     */
    @Override
    public MsgResultVO details(T model) {
        return defaultBack();
    }

    /**
     * 获取分页集合
     * @param requestPage 请求页数
     * @param size        请求显示条数
     * @param model       检索对象属性
     * @return 分页集合
     */
    @Override
    public MsgResultVO list(Integer requestPage, Integer size, T model) {
        return defaultBack();
    }

    /**
     * 获取所有对象
     * @param model 检索条件
     * @return 结果集合
     */
    @Override
    public MsgResultVO listAll(T model) {
        return defaultBack();
    }

    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */
    @Override
    public MsgResultVO isExist(T model) {
        return defaultBack();
    }
}
