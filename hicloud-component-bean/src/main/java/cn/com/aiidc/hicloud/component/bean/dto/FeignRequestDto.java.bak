package cn.com.aiidc.hicloud.component.bean.dto;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import cn.com.aiidc.hicloud.component.bean.exception.HicloudException;
import lombok.Data;

@Data
public class FeignRequestDto <T> implements java.io.Serializable {
	
	private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private Class<T> clazz;
	
	/**
	 * 请求时间戳
	 */
	public String timestamp;
	
	/**
	 * 用户名
	 */
	public String username;
	
	/**
	 * 令牌
	 */
	public String accesstoken;
	
	/**
	 * 表单令牌
	 */
	public String formtoken;
	
	/**
	 * 请求体
	 */
	//@Valid
	public T data;

	public T getData() {
		if(data != null) {
			Set<ConstraintViolation<T>> validate = validator.validate(data);
	        for (ConstraintViolation<T> model : validate) {
	            throw new HicloudException(model.getMessage());
	        }
		}
		return data;
	}
	
}
