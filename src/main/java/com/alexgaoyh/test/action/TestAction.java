/*package com.alexgaoyh.test.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.redis.util.RedisClient;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;
import com.alexgaoyh.sysman.admin.service.SysmanRoleService;
import com.alexgaoyh.sysman.admin.service.SysmanUserService;
import com.alexgaoyh.test.entity.TestEntity;
import com.alexgaoyh.test.service.TestService;

*//**
 * test方法，与业务无关
 * @author gaoyihang
 *
 *//*
@Controller
@RequestMapping(value="test")
public class TestAction {

	private static final Logger LOGGER = Logger.getLogger(TestAction.class);
	
	@Resource
	private SysmanUserService sysmanUserService;
	
	@Resource
	private SysmanRoleService sysmanRoleService;
	
	@Resource
	private SysmanResourceService sysmanResourceService;
	
	@Resource
	private TestService testService;
	
	@Resource
	private RedisClient<String, String> redisClient;
	
	
    @RequestMapping(value="login")  
    public ModelAndView login(){
    	//发送邮件demo
    	//EmailUtil.send("subject", "content", "924099504@qq.com");
    	redisClient.add("aaaa", "aaaa");
    	System.out.println(redisClient.get("aaaa"));
        return new ModelAndView("views/test");
    }
    
    @RequestMapping(value="test")
    @ResponseBody
    public String saveEntity() throws Exception{
    	TestEntity te = new TestEntity();
    	te.setName("alexgaoyh");
    	testService.saveOrUpdate(te);
    	return JSONObject.valueToString(te);
    }
    
    @RequestMapping(value="test1")
    @ResponseBody
    public String saveSysmanUserEntity() throws Exception{
    	SysmanUser su = new SysmanUser();
    	su.setUserName("admin");
    	su.setRealName("admim");
    	su.setPassword(new Md5Hash("admin").toHex());
    	su.setStatus(SysmanUser.STATUS_NORMAL);
    	sysmanUserService.saveOrUpdate(su);
    	return JSONObject.valueToString(su);
    }
    
    @RequestMapping(value="test2")
    @ResponseBody
    public String saveSysmanRoleEntity() throws Exception {
    	SysmanRole sr = new SysmanRole();
    	sr.setDescription("系统管理员");
    	sr.setName("系统管理员");
    	sysmanRoleService.saveOrUpdate(sr);
    	return JSONObject.valueToString(sr);
    }
    
    @RequestMapping(value="test3")
    @ResponseBody
    public String saveSysmanResourceEntity() throws Exception {
    	SysmanResource sr = new SysmanResource();
    	sr.setHref("/");
    	sr.setDescription("系统管理员");
    	sr.setName("系统管理员");
    	sr.setOrderNo(1);
    	sr.setResourceType(SysmanResource.TYPE_MENU);
    	sysmanResourceService.saveOrUpdate(sr);
    	return JSONObject.valueToString(sr);
    }
    
}
*/