package cn.com.aiidc.hicloud.test.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.com.aiidc.hicloud.test.dao.entity.TGoods;
import cn.com.aiidc.hicloud.test.vo.goods.GoodsVo;
import cn.com.aiidc.hicloud.test.vo.goods.ReduceGoodsVo;

public interface IGoodsService extends IService<TGoods> {
	
	boolean createGoods(GoodsVo goods);
	
	boolean reduceGoods(ReduceGoodsVo goods);

}
