package cn.com.aiidc.hicloud.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.aiidc.hicloud.component.bean.dto.RequestDto;
import cn.com.aiidc.hicloud.test.service.IGoodsService;
import cn.com.aiidc.hicloud.test.vo.goods.GoodsVo;
import cn.com.aiidc.hicloud.test.vo.goods.ReduceGoodsVo;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
	
	@Autowired
	IGoodsService goodsService;
	
	@PostMapping(value = "/create")
    public void create( @RequestBody RequestDto<GoodsVo> requestDto) throws Exception {
		GoodsVo data = requestDto.getData();
		goodsService.createGoods(data);
    }
	
	@PostMapping(value = "/reduce")
    public void reduce( @RequestBody RequestDto<ReduceGoodsVo> requestDto) throws Exception {
		ReduceGoodsVo data = requestDto.getData();
		goodsService.reduceGoods(data);
    }
	
}
