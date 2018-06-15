package com.owl.magicUtil.vo;

import com.owl.magicUtil.model.MsgResult;

import java.util.ArrayList;
import java.util.List;

/**
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/06/15.
 */
public final class TreeVO<T extends MsgResult> extends MsgResult {
    private Long id;
    private Long pid;

    private T temp;

    public T getTemp() {
        return temp;
    }

    public void setTemp(T temp) {
        this.temp = temp;
    }

    private List<TreeVO> treeVOList = new ArrayList<>();

    public TreeVO(Integer id, Integer pid, T t) {
        this.id = id.longValue();
        this.pid = pid.longValue();
        this.temp = t;
    }

    public TreeVO(Long id, Long pid, T t) {
        this.id = id;
        this.pid = pid;
        this.temp = t;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public List<TreeVO> getTreeVOList() {
        return treeVOList;
    }

    public void setTreeVOList(List<TreeVO> treeVOList) {
        this.treeVOList = treeVOList;
    }

    /**
     * 获取树
     * @param treeVOList 分樹的對象
     * @return
     */
    public static List<TreeVO> getTree(List<TreeVO> treeVOList) {
        List<TreeVO> root = new ArrayList<>();
        treeVOList.forEach(treeVO -> {
            if (null == treeVO.pid || treeVO.pid == 0 || treeVO.pid < 0) {
                root.add(getTrees(treeVO, treeVOList));
            }
        });
        return root;
    }

    /**
     * 获取子叶
     * @param root       根
     * @param treeVOList 子葉
     * @return
     */
    @SuppressWarnings("unchecked")
    private static TreeVO getTrees(TreeVO root, List<TreeVO> treeVOList) {
        treeVOList.forEach(treeVO -> {
            if (null != treeVO.pid && treeVO.pid.equals(root.id)) {
                root.treeVOList.add(getTrees(treeVO, treeVOList));
            }
        });
        return root;
    }
}
