package cn.com.aiidc.hicloud.demo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

public interface TUserMapper extends BaseMapper<TUser> {
	
	Page<UserVo> selectPageVo(Page<UserVo> page, @Param("name") String name);
	
	long selectTotal(@Param("name") String name);

}
