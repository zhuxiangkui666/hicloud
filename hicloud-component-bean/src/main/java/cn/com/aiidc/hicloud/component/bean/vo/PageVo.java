package cn.com.aiidc.hicloud.component.bean.vo;

import java.util.List;

import lombok.Data;

@Data
public class PageVo<T> {
		
	private long page = 1L;
	
	private int pageSize = 10;	
	
	private long totalPages = 0L;
	
	private List<T> records;
	
	private long total = 0L;
	
	

}
