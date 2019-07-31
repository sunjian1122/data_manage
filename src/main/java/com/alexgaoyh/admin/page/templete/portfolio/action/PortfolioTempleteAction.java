package com.alexgaoyh.admin.page.templete.portfolio.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.admin.page.templete.portfolio.entity.PortfolioTemplete;
import com.alexgaoyh.admin.page.templete.portfolio.entity.PortfolioType;
import com.alexgaoyh.admin.page.templete.portfolio.service.PortfolioTypeService;
import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;

/**
 * 
 * @desc 代表作品集-管理模板action控制类
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:29:07 CST 2014
 */
@Controller
@RequestMapping(value="admin/page/templete/portfolioTemplete")
public class PortfolioTempleteAction extends BaseController<PortfolioTemplete> {

	private static final Logger LOGGER = Logger.getLogger(PortfolioTemplete.class);
	
	@Override
	@Resource(name = "portfolioTempleteServiceImpl")
	public void setBaseService(BaseService<PortfolioTemplete> baseService) {
		this.baseService = baseService;
	}
	
	@Resource(name = "portfolioTypeServiceImpl")
	private PortfolioTypeService portfolioTypeService;
	
	@Override
	public ModelAndView list(ModelAndView model) {

		List<PortfolioType> portfolioTypeList = portfolioTypeService.getAll();
		model.addObject("portfolioTypeList", portfolioTypeList);

		return super.list(model);
	}

}
