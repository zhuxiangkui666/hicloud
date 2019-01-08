package cn.com.aiidc.hicloud.test.vo.goods;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GoodsVo {
	
	public Long id;
	@NotNull(message = "商品名称不能为空")
	public String name;
	@NotNull(message = "商品单价不能为空")
	public BigDecimal price;
	@NotNull(message = "商品数量不能为空")
	public Long num;
}
