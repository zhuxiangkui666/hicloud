package cn.com.aiidc.hicloud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.dao.mapper.TUserMapper;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

@Service
public class DemoService {
	
	@Autowired
	TUserMapper userMapper;
	
	public void newUser(UserVo user) {
		TUser po = new TUser();
		po.setName(user.getName());
		po.setMoney(user.getMoney());
		po.insert();
	}
	
	public TUser findUserByid(Long id) {
		TUser po = new TUser();
		//po.setId(id);
		TUser user = po.selectById(id);
		//TUser user = userMapper.selectById(id);
		return user;
	}

}
