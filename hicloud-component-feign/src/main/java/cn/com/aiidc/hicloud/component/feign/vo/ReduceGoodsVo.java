package cn.com.aiidc.hicloud.component.feign.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ReduceGoodsVo {
	
	@NotNull(message = "商品ID不能为空")
	public Long id;
	@NotNull(message = "商品数量不能为空")
	public Long num;
	
}
