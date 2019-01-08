package cn.com.aiidc.hicloud.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.aiidc.hicloud.component.bean.dto.RequestDto;
import cn.com.aiidc.hicloud.demo.dao.entity.TUser;
import cn.com.aiidc.hicloud.demo.service.DemoService;
import cn.com.aiidc.hicloud.demo.vo.LoginVo;
import cn.com.aiidc.hicloud.demo.vo.user.UserVo;

@RestController
public class DemoController {
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say() {
        return "hello world!";
    }
	
	@RequestMapping(value = "/obj",method = RequestMethod.GET)
    public Object obj() {
        return new HashMap();
    }
	
	@RequestMapping(value = "/map",method = RequestMethod.GET)
    public Map map() {
		Map map = new HashMap();
		map.put("key", "value");
        return map;
    }
	
	@RequestMapping(value = "/emptyMap",method = RequestMethod.GET)
    public Map emptyMap() {
		Map map = new HashMap();
        return map;
    }
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public List list() {
		List list = new ArrayList();
		list.add("list");
        return list;
    }
	
	@RequestMapping(value = "/emptyList",method = RequestMethod.GET)
    public List emptyList() {
		List list = new ArrayList();
        return list;
    }
	
	@RequestMapping(value = "/void",method = RequestMethod.GET)
    public void empty() {
		
    }
	
	@RequestMapping(value = "/err",method = RequestMethod.GET)
    public void err() throws Exception {
		throw new Exception();
    }
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginVo login( @RequestBody RequestDto<LoginVo> requestDto) throws Exception {
		return requestDto.getData();
    }
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/newUser",method = RequestMethod.POST)
    public void newUser( @RequestBody RequestDto<UserVo> requestDto) throws Exception {
		UserVo data = requestDto.getData();
		demoService.newUser(data);
    }
	
	@RequestMapping(value = "/findUserByid",method = RequestMethod.POST)
    public UserVo findUserByid( @RequestBody RequestDto<UserVo> requestDto) throws Exception {
		UserVo data = requestDto.getData();
		TUser user = demoService.findUserByid( data.getId() );
		if(user != null) {
			data.setId(user.getId());
			data.setName(user.getName());
			data.setMoney(user.getMoney());
		}
		
		return data;
    }

}
