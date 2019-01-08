package cn.com.aiidc.hicloud.demo.service.impl;

import java.util.Date;

import org.apache.servicecomb.pack.omega.transaction.annotations.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.com.aiidc.hicloud.component.bean.dto.FeignRequestDto;
import cn.com.aiidc.hicloud.component.bean.dto.ResponseDto;
import cn.com.aiidc.hicloud.component.bean.enums.ResponseEnums;
import cn.com.aiidc.hicloud.component.bean.exception.HicloudException;
import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.component.bean.vo.order.CreateOrderVo;
import cn.com.aiidc.hicloud.component.feign.vo.ReduceGoodsVo;
import cn.com.aiidc.hicloud.demo.dao.entity.TOrder;
import cn.com.aiidc.hicloud.demo.dao.mapper.TOrderMapper;
import cn.com.aiidc.hicloud.demo.feignService.FeignConsumerGoodsService;
import cn.com.aiidc.hicloud.demo.service.IOrderService;
import cn.com.aiidc.hicloud.demo.vo.order.OrderPageVo;
import cn.com.aiidc.hicloud.demo.vo.order.OrderVo;

@Service
public class OrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements IOrderService {
	
	@Autowired
	TOrderMapper orderMapper;
	
	@Autowired
	FeignConsumerGoodsService feignConsumerGoodsService;
	
	//@Transactional
	@Compensable(timeout=50, compensationMethod="cancelCreateOrder")
	@Override
	public boolean createOrder(CreateOrderVo vo) {
		TOrder order = new TOrder();
		order.setId(vo.getId());
		order.setUserId(vo.getUserId());
		order.setGoods(vo.getGoods());
		order.setMoney( vo.getMoney() );
		order.setCreateTime(new Date());
		order.setStatus("0");
		boolean flag = order.insert();
		return flag;
	}
	
	//@Transactional
	public boolean cancelCreateOrder(CreateOrderVo vo) {
		TOrder order = new TOrder();
		order.setId(vo.getId());
		return order.deleteById();
	}
	
	//@Transactional
	@Compensable(timeout=50, compensationMethod="cancelReduceGoods")
	@Override
	public void reduceGoods(CreateOrderVo vo) {
		FeignRequestDto<ReduceGoodsVo> feignRequestDto = new FeignRequestDto<ReduceGoodsVo>();
		ReduceGoodsVo data = new ReduceGoodsVo();
		data.setId( Long.valueOf(vo.getGoods()) );
		data.setNum(1L);
		feignRequestDto.setData(data);
		ResponseDto responseDto = feignConsumerGoodsService.reduceGoods(feignRequestDto);
		if( ResponseEnums.SUCCESS_OPTION.getCode().equals( responseDto.getCode() )) {
			throw new HicloudException();
		}
	}
	
	//@Transactional
	public boolean cancelReduceGoods(CreateOrderVo vo) {
		
		return true;
	}
	
	@Override
	public PageVo<OrderVo> selectPageVo(OrderPageVo vo){
		Page<OrderVo> page = new Page<OrderVo>(vo.getPage(), vo.getPageSize(), false);
		Page<OrderVo> recordPage = orderMapper.selectPageVo(page, vo);
		
		PageVo<OrderVo> pageVo = new PageVo<OrderVo>();
		pageVo.setPage(vo.getPage());
		pageVo.setPageSize(recordPage.getRecords().size());
		pageVo.setRecords(recordPage.getRecords());
		
		long total = orderMapper.selectTotal(vo);
		
		pageVo.setTotal(total);
		pageVo.setTotalPages(total % vo.getPageSize() == 0? total / vo.getPageSize() : total / vo.getPageSize() + 1);
		return pageVo;
	}
	
	
}
