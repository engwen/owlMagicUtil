package com.owl.magicUtil.model;


import com.owl.magicUtil.constant.MsgConstantEM;
import com.owl.magicUtil.vo.MsgResultVO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回基礎信息類，該類不可實例化直接使用
 * author engwen
 * email xiachanzou@outlook.com
 * 2017/10/23.
 */
public abstract class MsgResult implements Serializable {
    //序列化支持
    private static final long serialVersionUID = 1L;

    //添加將要返回的基礎數據
    private Boolean result;
    private String resultCode;
    private String resultMsg;

    //儅以上數據不能滿足需求時，提供另一個msgResult對象
    private MsgResult resultData;
    //儅以上數據仍不能滿足時，提供Map封裝參數
    private Map<String, Object> params;

    /*----------------------------  提供构造函数  --------------------------------*/
    public MsgResult() {
        this.result = true;
        this.params = new HashMap<>();
        setMsgConstantEM(MsgConstantEM.REQUEST_DEFAULT);
    }

    public MsgResult(Map<String, Object> params) {
        this.result = true;
        this.params = params;
        setMsgConstantEM(MsgConstantEM.REQUEST_DEFAULT);
    }

    public MsgResult(Boolean result, String resultCode, String resultMsg) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.params = new HashMap<>();
    }

    public MsgResult(Boolean result, MsgConstantEM em) {
        this.result = result;
        this.params = new HashMap<>();
        setMsgConstantEM(em);
    }

    public MsgResult(Boolean result, String resultCode, String resultMsg, Map<String, Object> params) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.params = params;
    }
    /*----------------------------  构造函数结束  --------------------------------*/

    private void setMsgConstantEM(MsgConstantEM msgConstantEM) {
        this.resultCode = msgConstantEM.getCode();
        this.resultMsg = msgConstantEM.getMsg();
    }

    /**
     * 請求失敗
     * @param em 枚举信息对象
     */
    public void errorResult(MsgConstantEM em) {
        this.result = false;
        setMsgConstantEM(em);
    }

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
        this.result = true;
        setMsgConstantEM(MsgConstantEM.REQUEST_SUCCESS);
    }

    /**
     * 請求成功
     * @param em 枚举信息对象
     */
    public void successResult(MsgConstantEM em) {
        this.result = true;
        setMsgConstantEM(em);
    }

    /**
     * 請求成功
     * @param resultCode 消息代碼
     * @param resultMsg 消息信息
     */
    public void successResult(String resultCode, String resultMsg) {
        this.result = true;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 將本類中的結果信息傳遞給其他的msg
     * @param anotherMsg 另一個msgResult
     * @return MsgResult 返回原來的引用
     */
    public MsgResult setThisMsgToAnotherMsg(MsgResult anotherMsg) {
        anotherMsg.setResult(this.result);
        anotherMsg.setResultCode(this.resultCode);
        anotherMsg.setResultMsg(this.resultMsg);
        return anotherMsg;
    }

    /**
     * 將其他msg的結果信息傳遞給本類
     * @param anotherMsg 另一個msgResult
     */
    public void getMsgByAnotherMsg(MsgResult anotherMsg) {
        this.result = anotherMsg.result;
        this.resultCode = anotherMsg.resultCode;
        this.resultMsg = anotherMsg.resultMsg;
    }

    /**
     * 向Map中传递参数名以及值
     * @param key   参数名称
     * @param value 值
     */
    public void setParam(String key, Object value) {
        this.params.put(key, value);
    }

    /**
     * 获取指定key的值
     * @param key 参数名称
     * @return
     */
    public Object getParamValue(String key) {
        return this.params.get(key);
    }

    /**
     * 移除Map中的參數
     * @param key 參數名
     */
    public void removeParam(String key) {
        this.params.remove(key);
    }

    /**
     * 生成可直接返回的目標對象，剝除多餘的對象信息
     * @return 目标对象
     */
    public MsgResult aimMsg() {
        return this.getResult() ? this : this.setThisMsgToAnotherMsg(new MsgResultVO());
    }

    /**
     * 为了方便查看结果信息，直接使用JSON格式
     * @return 字符串
     */
    public String toJSON() {
        return "{result:" + this.result + ",resultCode:" + this.resultCode + ",resultMsg:" + this.resultMsg + "}";
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
