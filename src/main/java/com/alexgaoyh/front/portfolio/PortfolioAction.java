package com.alexgaoyh.front.portfolio;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.admin.page.templete.portfolio.service.PortfolioTempleteService;
import com.alexgaoyh.admin.page.templete.portfolio.service.PortfolioTypeService;

@Controller
@RequestMapping(value="portfolio")
public class PortfolioAction {

	
	@Resource(name = "portfolioTypeServiceImpl")
	private PortfolioTypeService portfolioTypeService;
	
	@Resource(name = "portfolioTempleteServiceImpl")
	private PortfolioTempleteService portfolioTempleteService;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView blogItem(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("portfolioTypeList", portfolioTypeService.getAll());
		map.put("portfolioTempleteList", portfolioTempleteService.getAll());
		
		
		ModelAndView mav = new ModelAndView("/views/front/page/portfolio/portfolioTemplete/index", map);

		return mav;
	}
}
