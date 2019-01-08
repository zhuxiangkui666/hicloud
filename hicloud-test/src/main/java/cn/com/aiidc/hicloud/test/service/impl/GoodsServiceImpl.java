package cn.com.aiidc.hicloud.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.com.aiidc.hicloud.test.dao.entity.TGoods;
import cn.com.aiidc.hicloud.test.dao.mapper.TGoodsMapper;
import cn.com.aiidc.hicloud.test.service.IGoodsService;
import cn.com.aiidc.hicloud.test.vo.goods.GoodsVo;
import cn.com.aiidc.hicloud.test.vo.goods.ReduceGoodsVo;

@Service
public class GoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements IGoodsService {

	@Transactional
	@Override
	public boolean createGoods(GoodsVo vo) {
		TGoods goods = new TGoods();
		goods.setName(vo.getName());
		goods.setPrice(vo.getPrice());
		goods.setNum(vo.getNum());
		return goods.insert();
	}
	
	@Transactional
	@Override
	public boolean reduceGoods(ReduceGoodsVo vo) {
		TGoods goods = new TGoods();
		goods.setId(vo.getId());
		goods = goods.selectById();
		goods.setNum(goods.getNum() - vo.getNum());
		return goods.insertOrUpdate();
	}
	


	
}
