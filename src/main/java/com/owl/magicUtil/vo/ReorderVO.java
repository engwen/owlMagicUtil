package com.owl.magicUtil.vo;

import com.owl.magicUtil.model.ModelPrototype;

/**
 * 排序基类
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/06/15.
 */
public final class ReorderVO<T extends ModelPrototype> extends ModelPrototype {
    //序号
    private Integer order;

    public Integer getOrder() {
        return order;
    }

//    //初始化对象
//    public ReorderVO(Integer order, T object) {
//        this.order = order;
//        super.setResultData(object);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public T getResultData() {
//        return null != super.getResultData() ? (T) super.getResultData() : null;
//    }
}
