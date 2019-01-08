package cn.com.aiidc.hicloud.demo.vo.user;

import java.math.BigDecimal;

import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserPageVo extends PageVo {
	
	private static final long serialVersionUID = 1L;
		
	public String name;
	
	public BigDecimal money;
	
	
}
