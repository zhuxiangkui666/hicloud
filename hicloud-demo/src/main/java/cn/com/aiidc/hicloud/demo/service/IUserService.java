package cn.com.aiidc.hicloud.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.vo.user.UserPageVo;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

public interface IUserService extends IService<TUser> {
	
	PageVo<UserVo> selectPageVo(UserPageVo vo);
	
	IPage<TUser> selectPageVo2(UserPageVo vo);
	
	IPage<TUser> selectPageVo3(UserPageVo vo);

}
