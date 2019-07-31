package com.alexgaoyh.admin.page.templete.news.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexgaoyh.admin.page.templete.news.entity.NewsTemplete;
import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;

/**
 * 
 * @desc 新闻页面-管理模板action控制类
 *
 * @author alexgaoyh
 * @Thu Oct 16 18:16:40 CST 2014
 */
@Controller
@RequestMapping(value="admin/page/templete/newsTemplete")
public class NewsTempleteAction extends BaseController<NewsTemplete> {

	private static final Logger LOGGER = Logger.getLogger(NewsTemplete.class);
	
	@Override
	@Resource(name = "newsTempleteServiceImpl")
	public void setBaseService(BaseService<NewsTemplete> baseService) {
		this.baseService = baseService;
	}

}
