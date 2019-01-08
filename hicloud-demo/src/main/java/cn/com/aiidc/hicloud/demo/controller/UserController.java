package cn.com.aiidc.hicloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;

import cn.com.aiidc.hicloud.component.bean.dto.RequestDto;
import cn.com.aiidc.hicloud.component.bean.vo.PageVo;
import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.service.IUserService;
import cn.com.aiidc.hicloud.demo.vo.user.UserPageVo;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

@RestController
@RequestMapping(value = "/user")
public class UserController {
		
	@Autowired
	IUserService userService;
	
	@PostMapping(value = "/page")
    public PageVo<UserVo> page( @RequestBody RequestDto<UserPageVo> requestDto) throws Exception {
		UserPageVo data = requestDto.getData();
		return userService.selectPageVo(data);
    }
	
	@PostMapping(value = "/page2")
    public PageVo<TUser> page2( @RequestBody RequestDto<UserPageVo> requestDto) throws Exception {
		UserPageVo data = requestDto.getData();
		IPage<TUser> page = userService.selectPageVo2(data);
		
		PageVo<TUser> pageVo = new PageVo<TUser>();
		pageVo.setPage(data.getPage());
		pageVo.setPageSize(page.getRecords().size());
		pageVo.setRecords(page.getRecords());
		long total = page.getTotal();
		pageVo.setTotal(total);
		pageVo.setTotalPages( total % data.getPageSize() == 0? total / data.getPageSize() : total / data.getPageSize() + 1 );
		return pageVo;
    }
	
	@PostMapping(value = "/page3")
    public PageVo<TUser> page3( @RequestBody RequestDto<UserPageVo> requestDto) throws Exception {
		UserPageVo data = requestDto.getData();
		IPage<TUser> page = userService.selectPageVo3(data);
		
		PageVo<TUser> pageVo = new PageVo<TUser>();
		pageVo.setPage(data.getPage());
		pageVo.setPageSize(page.getRecords().size());
		pageVo.setRecords(page.getRecords());
		long total = page.getTotal();
		pageVo.setTotal(total);
		pageVo.setTotalPages( total % data.getPageSize() == 0? total / data.getPageSize() : total / data.getPageSize() + 1 );
		
		return pageVo;
    }
	
}
