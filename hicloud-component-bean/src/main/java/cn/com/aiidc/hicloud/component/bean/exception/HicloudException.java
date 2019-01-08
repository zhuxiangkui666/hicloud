package cn.com.aiidc.hicloud.component.bean.exception;

/**
 * 异常类
 * @author zhuxk
 *
 */
public class HicloudException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	private Exception exception;

	public HicloudException() {
		super();
	}
	
	public HicloudException(String msg) {
		super(msg);
		this.code = "";
		this.msg = msg;
		this.exception = null;
	}

	public HicloudException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
		this.exception = null;
	}
	
	public HicloudException(String code, String msg, Exception e) {
		super(msg);
		this.code = code;
		this.msg = msg;
		this.exception = e;
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

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	

}
