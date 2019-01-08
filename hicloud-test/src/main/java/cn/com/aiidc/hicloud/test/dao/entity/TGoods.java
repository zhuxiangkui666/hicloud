package cn.com.aiidc.hicloud.test.dao.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TGoods extends Model<TGoods> {
	
	@TableId(type = IdType.ID_WORKER)
	private Long id;
	private String name;
	private BigDecimal price;
	private Long num;
	
}
