package cn.com.aiidc.hicloud.demo.controller;

import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.aiidc.hicloud.component.bean.dto.RequestDto;
import cn.com.aiidc.hicloud.component.bean.exception.HicloudException;
import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.component.bean.vo.order.CreateOrderVo;
import cn.com.aiidc.hicloud.demo.service.IOrderService;
import cn.com.aiidc.hicloud.demo.vo.order.OrderPageVo;
import cn.com.aiidc.hicloud.demo.vo.order.OrderVo;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
		
	@Autowired
	IOrderService orderService;
	
	@PostMapping(value = "/create")
	@SagaStart(timeout=100)
    public void create( @RequestBody RequestDto<CreateOrderVo> requestDto) {
		CreateOrderVo data = requestDto.getData();
		data.setId(System.currentTimeMillis());
		boolean flag = orderService.createOrder(data);
		if(flag) {
			orderService.reduceGoods(data);
		}else {
			throw new HicloudException();
		}
		
    }
	
	@PostMapping(value = "/page")
    public PageVo<OrderVo> page( @RequestBody RequestDto<OrderPageVo> requestDto) {
		OrderPageVo data = requestDto.getData();
		return orderService.selectPageVo(data);
    }
	
	
	
	
}
