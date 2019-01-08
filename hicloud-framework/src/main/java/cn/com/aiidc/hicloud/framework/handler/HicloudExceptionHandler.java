package cn.com.aiidc.hicloud.framework.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.aiidc.hicloud.component.bean.dto.ResponseDto;
import cn.com.aiidc.hicloud.component.bean.exception.HicloudException;

/**
 * 统一异常处理器
 * @author zhuxk
 *
 */
@ControllerAdvice
public class HicloudExceptionHandler {

	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 通用异常处理
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseDto exception(HttpServletRequest req,Exception e){
		e.printStackTrace();
		log.error(e.getStackTrace(), e);
		ResponseDto responseDto = new ResponseDto(false, "", "", "", e);//响应报文
		return responseDto;
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseDto sqlException(HttpServletRequest req,Exception e){
		e.printStackTrace();
		log.error(e.getStackTrace(), e);
		ResponseDto responseDto = new ResponseDto(false, "", "", "", e);//响应报文
		return responseDto;
	}
		
	/**
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseDto httpMessageNotReadableException(HttpServletRequest req,HttpMessageNotReadableException e){
		e.printStackTrace();
		log.error(e.getStackTrace(), e);
		ResponseDto responseDto = new ResponseDto(false, "", "", "", e);//响应报文
		return responseDto;
	}
	
	/**
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HicloudException.class)
	@ResponseBody
	public ResponseDto hicloudException(HttpServletRequest req,HicloudException e){
		e.printStackTrace();
		log.error(e.getStackTrace(), e);
		ResponseDto responseDto = new ResponseDto(false, "", "", "", e);//响应报文
		return responseDto;
	}
	
}
