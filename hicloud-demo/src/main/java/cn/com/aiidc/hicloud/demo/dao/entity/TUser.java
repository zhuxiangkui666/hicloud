package cn.com.aiidc.hicloud.demo.dao.entity;

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
public class TUser extends Model<TUser> {
	
	@TableId(type = IdType.ID_WORKER)
	private Long id;
	private String name;
	private BigDecimal money;
	
	
}
