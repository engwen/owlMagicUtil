package com.owl.magicUtil.util;

/**
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/06/15.
 */

import com.owl.magicUtil.model.ModelPrototype;
import com.owl.magicUtil.vo.ReorderVO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderUtil<T extends ModelPrototype> {
    public List<T> getSort(List<ReorderVO<T>> reorderVOList) {
        List<T> result = new ArrayList<>();
        reorderVOList.sort(new ReorderRule());
        reorderVOList.forEach(reorderVO -> result.add(reorderVO.getResultData()));
        return result;
    }
}


class ReorderRule implements Comparator<ReorderVO> {
    @Override
    public int compare(ReorderVO o1, ReorderVO o2) {
        int flag = 0;
        //含有为空的排序，则默认将其后置
        if (null == o1.getOrder() && null != o2.getOrder()) {
            flag = -1;
        } else if (null != o1.getOrder() && null == o2.getOrder()) {
            flag = 1;
        } else if (null != o1.getOrder() && null != o2.getOrder()) {
            //都不为空按照大小排序
            if (o1.getOrder() - o2.getOrder() > 0) {
                flag = 1;
            } else if (o1.getOrder() - o2.getOrder() < 0) {
                flag = -1;
            }
        }
        return flag;
    }
}
