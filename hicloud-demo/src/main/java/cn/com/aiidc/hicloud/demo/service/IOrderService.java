package cn.com.aiidc.hicloud.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.component.bean.vo.order.CreateOrderVo;
import cn.com.aiidc.hicloud.demo.dao.entity.TOrder;
import cn.com.aiidc.hicloud.demo.vo.order.OrderPageVo;
import cn.com.aiidc.hicloud.demo.vo.order.OrderVo;

public interface IOrderService extends IService<TOrder> {
	
	boolean createOrder(CreateOrderVo vo);
	
	boolean cancelCreateOrder(CreateOrderVo vo);
		
	void reduceGoods(CreateOrderVo vo);
	
	boolean cancelReduceGoods(CreateOrderVo vo);
	
	PageVo<OrderVo> selectPageVo(OrderPageVo vo);

}
