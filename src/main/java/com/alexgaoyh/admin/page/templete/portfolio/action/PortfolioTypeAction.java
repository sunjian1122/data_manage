package com.alexgaoyh.admin.page.templete.portfolio.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexgaoyh.admin.page.templete.portfolio.entity.PortfolioType;
import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;

/**
 * 
 * @desc 代表作品集_类型-管理模板action控制类
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:08:35 CST 2014
 */
@Controller
@RequestMapping(value="admin/page/templete/portfolioType")
public class PortfolioTypeAction extends BaseController<PortfolioType> {

	private static final Logger LOGGER = Logger.getLogger(PortfolioType.class);
	
	@Override
	@Resource(name = "portfolioTypeServiceImpl")
	public void setBaseService(BaseService<PortfolioType> baseService) {
		this.baseService = baseService;
	}

}
