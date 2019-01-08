package cn.com.aiidc.hicloud.demo.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TOrder extends Model<TOrder> {
	
	@TableId(type = IdType.INPUT)
	private Long id;
	private Long userId;
	private String goods;
	private BigDecimal money;
	private Date createTime;
	private String status;
	
}
