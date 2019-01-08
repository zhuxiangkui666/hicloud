package cn.com.aiidc.hicloud.framework.handler;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.aiidc.hicloud.component.bean.dto.ResponseDto;
import cn.com.aiidc.hicloud.component.bean.enums.ResponseEnums;

/**
 * 统一响应报文处理器
 * @author zhuxk
 *
 */
@ControllerAdvice
public class HicloudResponseHandler implements ResponseBodyAdvice {

	private ThreadLocal<ObjectMapper> mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);
	
	private static final Class[] annos = {
			RequestMapping.class,
			GetMapping.class,
			PostMapping.class,
			DeleteMapping.class,
			PutMapping.class 
	}; 
	/**
     * 对所有RestController的接口方法进行拦截
     */
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		AnnotatedElement element = returnType.getAnnotatedElement();
		return Arrays.stream(annos).anyMatch( anno -> anno.isAnnotation() && element.isAnnotationPresent(anno) );
	}
	
	@Override
	public Object beforeBodyWrite( @Nullable Object body, MethodParameter returnType, 
			MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response ) {
		
		Object out = null;
		ObjectMapper mapper = mapperThreadLocal.get();
		response.getHeaders().setContentType( MediaType.APPLICATION_JSON );
		if(body == null) {
			out = new ResponseDto(true, "", ResponseEnums.SUCCESS_OPTION, null);
		}else if(body instanceof ResponseDto){
			out = body;
		}else if (body instanceof ResponseEnums){
			out = new ResponseDto(true, "", (ResponseEnums) body, null);
		} else if (body instanceof String){
			try {
				//因为是String类型，我们要返回Json字符串，否则SpringBoot框架会转换出错
				out = new ResponseDto(true, body, ResponseEnums.SUCCESS_OPTION, null);
				out = mapper.writeValueAsString(out);
			} catch (JsonProcessingException e) {
				ResponseEnums enums = ResponseEnums.JSON_PARSE_ERROR;
				enums.setMsg(e.getMessage());
				ResponseDto dto = new ResponseDto(false, "", enums, e);
				out = dto;
				try {
					out = mapper.writeValueAsString(out);
				} catch (JsonProcessingException ee) {
					ee.printStackTrace();
				}
			}
		} else{
			out = new ResponseDto(true, body, ResponseEnums.SUCCESS_OPTION, null);
		}
		return out;		
	}


}
