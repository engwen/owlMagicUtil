package com.owl.magicUtil.constant;

/**
 * author engwen
 * email xiachanzou@outlook.com
 * time 2017/10/26.
 */
public interface MsgConstantUtil {
    String REQUEST_SUCCESS_CODE = "0000";
    String REQUEST_SUCCESS_MSG = "请求成功";

    String REQUEST_DEFAULT_ERROR_CODE = "0001";
    String REQUEST_DEFAULT_ERROR_MSG = "默认返回数据";

    String REQUEST_PARAMETER_ERROR_CODE = "0002";
    String REQUEST_PARAMETER_ERROR_MSG = "请求参数错误";

    String REQUEST_NO_KNOW_ERROR_CODE = "0003";
    String REQUEST_NO_KNOW_ERROR_MSG = "未知错误";

    String REQUEST_NO_SIGNIN_ERROR_CODE = "0004";
    String REQUEST_NO_SIGNIN_ERROR_MSG = "用户未登录";

    String REQUEST_PERMISSION_DEFINED_ERROR_CODE = "0005";
    String REQUEST_PERMISSION_DEFINED_ERROR_MSG = "权限拒绝";

    String REQUEST_DB_PERMISSION_DEFINED_ERROR_CODE = "0006";
    String REQUEST_DB_PERMISSION_DEFINED_ERROR_MSG = "底层权限拒绝";

    String REQUEST_ACCOUNT_OR_PASSWORD_ERROR_CODE = "0007";
    String REQUEST_ACCOUNT_OR_PASSWORD_ERROR_MSG = "账号或密码错误";

    String REQUEST_NOT_EXITS_ERROR_CODE = "0008";
    String REQUEST_NOT_EXITS_ERROR_MSG = "没有符合要求的数据";

    String REQUEST_IS_EXITS_ERROR_CODE = "0009";
    String REQUEST_IS_EXITS_ERROR_MSG = "该数据已存在";


    String REQUEST_CANT_UPDATE_ADMIN_ERROR_CODE = "0010";
    String REQUEST_CANT_UPDATE_ADMIN_ERROR_MSG = "管理员状态不可修改";

    String REQUEST_CANT_UPDATE_STATUS_ERROR_CODE = "0020";
    String REQUEST_CANT_UPDATE_STATUS_ERROR_MSG = "更新操作不能进行删除操作";
    
    String PARAM_EMAIL_ERROR_CODE = "1001";
    String PARAM_EMAIL_ERROR_MSG = "邮箱格式错误";

    String PARAM_MOBILE_ERROR_CODE = "1002";
    String PARAM_MOBILE_ERROR_MSG = "手机号格式错误";

    String PARAM_ACCOUNT_ERROR_CODE = "1003";
    String PARAM_ACCOUNT_ERROR_MSG = "账户错误";
}
