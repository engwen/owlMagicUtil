package com.owl.magicUtil.controller;

import com.owl.magicUtil.model.ModelPrototype;
import com.owl.magicUtil.vo.MsgResultVO;
import com.owl.magicUtil.vo.PageVO;

import java.util.List;

/**
 * 用于定义controller基础类
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/07/16.
 */
interface CellBaseController<T extends ModelPrototype> {

    /**
     * 创建
     * @param model 将要被创建的对象
     * @return 创建后的对象返回数据
     */
    MsgResultVO<T> create(T model);

    /**
     * 批量创建
     * @param list 待创建对象集合
     * @return 结果
     */
    MsgResultVO createList(List<T> list);

    /**
     * 删除功能
     * @param model 待删除的对象
     * @return 结果
     */
    MsgResultVO delete(T model);

    /**
     * 批量删除
     * @param idList 待删除的id集合
     * @return 结果
     */
    MsgResultVO deleteList(List<Long> idList);

    /**
     * 更新
     * @param model 将要被更新的对象
     * @return 结果
     */
    MsgResultVO<T> update(T model);

    /**
     * 获取详情
     * @param model 获取详情的对象唯一属性
     * @return 结果对象
     */
    MsgResultVO<T> details(T model);

    /**
     * 获取分页集合
     * @param requestPage 请求页数
     * @param rows        请求显示条数
     * @param model       检索对象属性
     * @return 分页集合
     */
    MsgResultVO<PageVO<T>> list(Integer requestPage, Integer rows, T model);

    /**
     * 获取所有对象
     * @param model 检索条件
     * @return 结果集合
     */
    MsgResultVO<List<T>> listAll(T model);


    /**
     * 檢查数据是否存在
     * @param model 检索条件
     * @return Boolean
     */
    MsgResultVO isExist(T model);
}
