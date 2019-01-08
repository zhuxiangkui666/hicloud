package cn.com.aiidc.hicloud.framework.handler;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 统一请求报文处理
 */
@ControllerAdvice(basePackages = "cn.com.aiidc.hicloud")
public class HicloudRequestHandler implements RequestBodyAdvice {
	
	private Log log = LogFactory.getLog(this.getClass());

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		return body;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		try {
			return new HicloudHttpInputMessage(inputMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return inputMessage;
		}
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return body;
	}

	private class HicloudHttpInputMessage implements HttpInputMessage {
		private HttpHeaders headers;
		private InputStream body;

		public HicloudHttpInputMessage(HttpInputMessage inputMessage) throws Exception {
			this.headers = inputMessage.getHeaders();
			this.body = IOUtils.toInputStream( IOUtils.toString(inputMessage.getBody(), "UTF-8") );
			/*
			if(StringUtils.hasText(body)) {
				ObjectMapper postMapper = new ObjectMapper();
				Map<String, Object> readValue = postMapper.readValue(body, Map.class);
				this.body = IOUtils.toInputStream( (CharSequence) readValue.get("data") );
			}
			*/
		}

		@Override
		public InputStream getBody() throws IOException {
			return body;
		}

		@Override
		public HttpHeaders getHeaders() {
			return headers;
		}
	}
}
