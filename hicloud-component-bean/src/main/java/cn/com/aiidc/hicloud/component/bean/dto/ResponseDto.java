package cn.com.aiidc.hicloud.component.bean.dto;

import java.io.Serializable;

import cn.com.aiidc.hicloud.component.bean.enums.ResponseEnums;
import lombok.Data;

@Data
public class ResponseDto <T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private T data;
	private String code;
	private String msg;
	private Exception exception;
 
	public ResponseDto(){
		
	}
 
	public ResponseDto(boolean success, T data, String code, String msg, Exception exception) {
		super();
		this.success = success;
		this.data = data;
		this.code = code;
		this.msg = msg;
		this.exception = exception;
	}
	
	public ResponseDto(boolean success,T data,ResponseEnums enums, Exception exception){
		this.success=success;
		this.data=data;
		this.code=enums.getCode();
		this.msg=enums.getMsg();
		this.exception = exception;
	}
	
 
}
