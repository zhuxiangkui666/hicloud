package cn.com.aiidc.hicloud.component.bean.enums;
 
public enum ResponseEnums {
 
	SUCCESS_OPTION(           "000","操作成功！"),
	LOGIN_SUCCESS(			  "001","登陆成功"),
	LOGOUT_SUCCESS(			  "002","注销成功"),
	FILEUPLOAD_SUCCESS(		  "003","上传成功"),
	DOWNLOAD_SUCCESS(		  "004","下载成功"),
	SENDEMAIL_SUCCESS(		  "005","邮件已发送，请注意查收"),
	EDITPWD_SUCCESS(		  "006","修改密码成功"),
	SMS_SUCCESS(		 	  "007","短信发送成功"),
	
	ILLEGAL_ARGUMENT(		  "400","参数不合法"),
	BAD_REQUEST(              "401","错误的请求参数"),
	BAD_REQUEST_TYPE(         "402","错误的请求类型"),
	INVALID_MOBILE(           "403","无效的手机号码"),
	INVALID_EMAIL(            "404","无效的邮箱"),
	INVALID_GENDER(           "405","无效的性别"),
	REPEAT_MOBILE(			  "406","已存在此手机号"),
	REPEAT_EMAIL(			  "407","已存在此邮箱地址"),
	NO_RECORD(				  "408","没有查到相关记录"),
	REPEAT_REGISTER(          "409","重复注册"),
	NO_USER_EXIST(            "410","用户不存在"),
	INVALID_PASSWORD(         "411","密码错误"),
	NO_PERMISSION(            "412","非法请求！"),
	No_FileSELECT(			  "413","未选择文件"),
	ERROR_IDCODE(			  "414","验证码不正确"),
	NOT_MATCH(                "415","用户名和密码不匹配"),
	FAIL_GETDATA(             "416","获取信息失败"),
	NOLOGIN(				  "417","未登陆"),
	
	SYSTEM_ERROR(             "500","系统异常"),
	NOT_FOUND(                "501","找不到请求路径！"),
	CONNECTION_ERROR(         "502","网络连接请求失败！"),
	METHOD_NOT_ALLOWED(		  "503","不合法的请求方式"),
	DATABASE_ERROR(			  "504","数据库异常"),
	BOUND_STATEMENT_NOT_FOUNT("505","找不到方法！"),
	JSON_PARSE_ERROR(		  "506","Json解析错误");
	
 
	private String code;
	
	private String msg;
	
	private ResponseEnums(String code, String msg) {
		this.code = code;
		this.msg = msg;
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
