package cn.com.aiidc.hicloud.component.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.com.aiidc.hicloud.component.bean.dto.FeignRequestDto;
import cn.com.aiidc.hicloud.component.bean.dto.ResponseDto;
import cn.com.aiidc.hicloud.component.feign.vo.ReduceGoodsVo;

@FeignClient("hicloud-test")
public interface FeignGoodsService {

	@PostMapping("/goods/reduce")
	ResponseDto reduceGoods(@RequestBody FeignRequestDto<ReduceGoodsVo> feignRequestDto);
}
