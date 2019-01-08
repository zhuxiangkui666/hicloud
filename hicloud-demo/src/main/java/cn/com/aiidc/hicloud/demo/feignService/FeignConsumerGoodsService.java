package cn.com.aiidc.hicloud.demo.feignService;

import org.springframework.cloud.openfeign.FeignClient;

import cn.com.aiidc.hicloud.component.feign.service.FeignGoodsService;

@FeignClient("hicloud-test")
public interface FeignConsumerGoodsService extends FeignGoodsService {

}
