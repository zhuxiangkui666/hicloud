package cn.com.aiidc.hicloud.component.bean.dto;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.aiidc.hicloud.component.bean.exception.HicloudException;
import lombok.Data;

@Data
public class RequestDto <T> implements java.io.Serializable {
	
	private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private Class<T> clazz;
	
	private HttpServletRequest request = null;
	
	private HttpServletResponse response = null;
	
	private HttpSession session = null;
	
	private ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
	
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
		
	public HttpServletRequest getRequest() {
		if(request == null) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			request = requestAttributes.getRequest();
		}
		return request;
	}

	public HttpServletResponse getResponse() {
		if(response == null) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			response = requestAttributes.getResponse();
		}
		return response;
	}

	public HttpSession getSession() {
		if(session == null) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			session = requestAttributes.getRequest().getSession();
		}
		return session;
	}

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
