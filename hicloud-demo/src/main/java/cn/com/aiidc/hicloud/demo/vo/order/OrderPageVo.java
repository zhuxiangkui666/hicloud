package cn.com.aiidc.hicloud.demo.vo.order;

import java.math.BigDecimal;

import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import lombok.Data;

@Data
public class OrderPageVo extends PageVo {
			
	public String username;
	
	public BigDecimal money;
	
	
}
