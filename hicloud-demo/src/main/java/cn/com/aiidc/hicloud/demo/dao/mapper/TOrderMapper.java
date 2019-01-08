package cn.com.aiidc.hicloud.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.com.aiidc.hicloud.demo.dao.entity.TOrder;
import cn.com.aiidc.hicloud.demo.vo.order.OrderPageVo;
import cn.com.aiidc.hicloud.demo.vo.order.OrderVo;

public interface TOrderMapper extends BaseMapper<TOrder> {
	
	Page<OrderVo> selectPageVo(Page<OrderVo> page, @Param("vo") OrderPageVo vo);
	
	long selectTotal(@Param("vo") OrderPageVo vo);
	
}
