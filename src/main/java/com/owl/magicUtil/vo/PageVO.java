package com.owl.magicUtil.vo;


import com.owl.magicUtil.model.MsgResult;
import com.owl.magicUtil.util.RegexUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分頁對象
 * @author engwen
 *         email xiachanzou@outlook.com
 *         2017/9/4.
 */
public class PageVO<T> extends MsgResult {
    //對象集合
    private List<T> objectList = new ArrayList<T>();
    //縂頁數
    private Integer sumPage = 1;
    //縂條數
    private Integer sum = 0;
    //每頁顯示條數
    private Integer size = 14;
    //請求的頁面
    private Integer requestPage = 0;

    //數據請求起點
    private Integer upLimit = 0;
    //數據請求終點
    private Integer downLimit = 0;
    //將要顯示的頁數下標
    private int[] pageList = new int[]{};

    /**
     * 塞入總數，請求頁數，每頁數量
     */
    public void initPageVO(Integer sum, Integer requestPage, Integer size) {
        if (null != sum && sum > 0) {
            this.sum = sum;
        }
        if (null != requestPage) {
            this.requestPage = requestPage;
        }
        if (null != size && size > 0) {
            this.size = size;
        }
        if (this.sum != 0) {
            this.sumPage = (int) Math.ceil(this.sum * 1.0 / this.size);
        } else {
            this.sumPage = 1;
        }

        //超出範圍使用1
        if (this.requestPage <= 0 || this.requestPage > sumPage) {
            this.requestPage = 1;
        }
        this.upLimit = (this.requestPage - 1) * this.size;
        if (this.requestPage < sumPage) {
            this.downLimit = this.requestPage * this.size;
        } else {
            this.downLimit = this.sum;
        }


        int firstPage = 1, lastPage = this.sumPage, middlePage = 0;
        //縂頁數小於11，全部顯示
        if (this.sumPage < 11) {
            this.pageList = new int[lastPage];
            for (int i = 0; i < lastPage; i++) {
                this.pageList[i] = i + 1;
            }
        } else {
            //縂頁數大於11，顯示1，。。。，左-3，請求頁，右-3 ... 尾頁 共11個頁數
            this.pageList = new int[11];
            if (this.requestPage < 9) {
                for (int i = 0; i < 9; i++) {
                    this.pageList[i] = i + 1;
                }
                this.pageList[9] = 0;
                this.pageList[10] = lastPage;
            } else {
                this.pageList[0] = firstPage;
                this.pageList[1] = middlePage;
                if (this.requestPage < this.sumPage - 5) {
                    this.pageList[5] = this.requestPage;
                    for (int i = 1; i < 4; i++) {
                        this.pageList[5 - i] = this.requestPage - i;
                        this.pageList[5 + i] = this.requestPage + i;
                    }
                    this.pageList[9] = middlePage;
                    this.pageList[10] = lastPage;
                } else {
                    for (int i = 0; i < 9; i++) {
                        this.pageList[i + 2] = lastPage - 8 + i;
                    }
                }
            }
        }
    }

    /**
     * 將本部的pageVO屬性賦值給薪傳進來的new PageVO 即屬性傳遞
     * @param newPage
     * @return
     */
    public PageVO setThisPageToAnotherPage(PageVO newPage) {
        if (!RegexUtil.haveEmpty(newPage)) {
            newPage.setRequestPage(this.requestPage);
            newPage.setSize(this.size);
            newPage.setSumPage(this.sumPage);
            newPage.setSum(this.sum);
            newPage.setUpLimit(this.upLimit);
            newPage.setDownLimit(this.downLimit);
            newPage.setPageList(this.pageList);
        }
        return newPage;
    }


    public Integer getSumPage() {
        return sumPage;
    }

    private void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

    public Integer getSum() {
        return sum;
    }

    private void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getSize() {
        return size;
    }

    private void setSize(Integer size) {
        this.size = size;
    }

    public Integer getRequestPage() {
        return requestPage;
    }

    private void setRequestPage(Integer requestPage) {
        this.requestPage = requestPage;
    }

    public Integer getUpLimit() {
        return upLimit;
    }

    private void setUpLimit(Integer upLimit) {
        this.upLimit = upLimit;
    }

    public Integer getDownLimit() {
        return downLimit;
    }

    private void setDownLimit(Integer downLimit) {
        this.downLimit = downLimit;
    }

    public int[] getPageList() {
        return pageList;
    }

    private void setPageList(int[] pageList) {
        this.pageList = pageList;
    }
}
