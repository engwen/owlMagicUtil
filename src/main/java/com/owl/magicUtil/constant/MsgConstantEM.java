package com.owl.magicUtil.constant;

/**
 * 该类用于msgResult中的错误信息，提供依据code码，返回错误详情功能
 * author engwen
 * email xiachanzou@outlook.com
 * time 2018/07/24.
 */
public enum MsgConstantEM {

    REQUEST_SUCCESS("0000", "请求成功"),
    REQUEST_DEFAULT("0001", "默认返回数据"),
    REQUEST_PARAMETER_ERROR("0002", "请求参数错误"),
    REQUEST_NO_KNOW_ERROR("0003", "未知错误"),
    REQUEST_NO_SIGNIN("0004", "用户未登录"),
    REQUEST_PERMISSION_DEFINED("0005", "权限拒绝"),
    REQUEST_DB_PERMISSION_DEFINED("0006", "底层权限拒绝"),
    REQUEST_ACCOUNT_OR_PASSWORD("0007", "账号或密码错误"),
    REQUEST_NOT_EXITS("0008", "没有符合要求的数据"),
    REQUEST_IS_EXITS("0009", "该数据已存在"),
    REQUEST_CANT_UPDATE_ADMIN("0010", "管理员状态不可修改"),
    REQUEST_METHOD_NOT_EXITS("0011", "该方法（接口）不存在，请检查代码"),
    REQUEST_DB_ERROR("0012", "底层sql错误,请检查代码"),

    REQUEST_CANT_UPDATE_STATUS("0020", "更新操作不能进行删除操作"),


    PARAM_EMAIL_ERROR("1001", "邮箱格式错误"),
    PARAM_MOBILE_ERROR("1002", "手机号格式错误"),
    PARAM_ACCOUNT_ERROR("1003", "账户错误");

    private String code;
    private String msg;

    MsgConstantEM(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MsgConstantEM getMsgConstantEMByCode(String code) {
        MsgConstantEM result = null;
        for (MsgConstantEM em : MsgConstantEM.values()) {
            if (em.getCode().equals(code)) {
                result = em;
                break;
            }
        }
        return result;
    }

    public static String getMsgByCode(String code) {
        return getMsgConstantEMByCode(code).getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
