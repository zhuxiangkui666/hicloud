package cn.com.aiidc.hicloud.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.dao.mapper.TUserMapper;
import cn.com.aiidc.hicloud.demo.service.IUserService;
import cn.com.aiidc.hicloud.demo.vo.user.UserPageVo;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements IUserService {
	
	@Autowired
	TUserMapper userMapper;
	
	@Override
	public PageVo<UserVo> selectPageVo(UserPageVo vo){
		Page<UserVo> page = new Page<UserVo>(vo.getPage(), vo.getPageSize(), false);
		Page<UserVo> recordPage = userMapper.selectPageVo(page, vo.getName());
		
		PageVo<UserVo> pageVo = new PageVo<UserVo>();
		pageVo.setPage(vo.getPage());
		pageVo.setPageSize(recordPage.getRecords().size());
		pageVo.setRecords(recordPage.getRecords());
		
		long total = userMapper.selectTotal( vo.getName() );
		
		pageVo.setTotal(total);
		pageVo.setTotalPages(total % vo.getPageSize() == 0? total / vo.getPageSize() : total / vo.getPageSize() + 1);
		return pageVo;
	}
	
	@Override
	public IPage<TUser> selectPageVo2(UserPageVo vo){
		TUser user = new TUser();
		Page<TUser> page = new Page<TUser>(vo.getPage(), vo.getPageSize(), false);
		LambdaQueryWrapper<TUser> queryWrapper = new QueryWrapper<TUser>().lambda().like(TUser::getName, vo.getName());
		IPage<TUser> selectPage = user.selectPage(page, queryWrapper);
		selectPage.setTotal( userMapper.selectTotal(vo.getName()) );
		return selectPage;
	}
	
	@Override
	public IPage<TUser> selectPageVo3(UserPageVo vo){
		Page<TUser> page = new Page<TUser>(vo.getPage(), vo.getPageSize(), false);
		LambdaQueryWrapper<TUser> queryWrapper = new QueryWrapper<TUser>().lambda().like(TUser::getName, vo.getName());
		IPage<TUser> selectPage = userMapper.selectPage(page, queryWrapper);
		selectPage.setTotal( userMapper.selectTotal(vo.getName()) );
		return selectPage;
	}
	
}
