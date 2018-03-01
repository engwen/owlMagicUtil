package com.owl.magicUtil.model;


import com.owl.magicUtil.constant.MsgConstantUtil;

import java.io.Serializable;

/**
 * 返回基礎信息類
 * author engwen
 * email xiachanzou@outlook.com
 * 2017/10/23.
 */
public class MsgResult implements Serializable {

    private static final long serialVersionUID = 1L;

    //添加返回信息数据
    private Boolean result = true;
    private String resultCode = MsgConstantUtil.REQUEST_DEFAULT_ERROR_CODE;
    private String resultMsg = MsgConstantUtil.REQUEST_DEFAULT_ERROR_MSG;

    //儅以上數據不能滿足時，提供另一個msgResult對象
    private MsgResult resultData;

    /**
     * 請求失敗
     * @param resultCode 消息代碼
     * @param resultMsg  消息信息
     */
    public void errorResult(String resultCode, String resultMsg) {
        this.result = false;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 請求成功
     */
    public void successResult() {
        this.resultCode = MsgConstantUtil.REQUEST_SUCCESS_CODE;
        this.resultMsg = MsgConstantUtil.REQUEST_SUCCESS_MSG;
    }

    /**
     * 請求成功
     */
    public void successResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 將本類中的結果信息傳遞給其他的msg
     * @param anotherMsg 另一個msgResult
     */
    public void setThisMsgToAnotherMsg(MsgResult anotherMsg) {
        anotherMsg.setResult(this.result);
        anotherMsg.setResultCode(this.resultCode);
        anotherMsg.setResultMsg(this.resultMsg);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public MsgResult getResultData() {
        return resultData;
    }

    public void setResultData(MsgResult resultData) {
        this.resultData = resultData;
    }

}
