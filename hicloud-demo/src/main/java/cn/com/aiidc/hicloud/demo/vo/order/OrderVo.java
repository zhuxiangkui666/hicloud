package cn.com.aiidc.hicloud.demo.vo.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderVo implements Serializable {
	
	public Long id;
	
	@NotNull(message = "用户ID不能为空")
	public Long userId;
	
	@NotNull(message = "商品ID不能为空")
	public String goods;
	
	public BigDecimal money;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date createTime;
	
	public String status;
	
	public String username;

	
}
