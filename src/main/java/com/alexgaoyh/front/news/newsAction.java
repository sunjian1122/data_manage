package com.alexgaoyh.front.news;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.admin.page.templete.news.entity.NewsTemplete;
import com.alexgaoyh.admin.page.templete.news.service.NewsTempleteService;

@Controller
@RequestMapping(value="news")
public class newsAction {

	private static final Logger LOGGER = Logger.getLogger(newsAction.class);
	
	@Resource(name = "newsTempleteServiceImpl")
	private NewsTempleteService newsTempleteService;
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ModelAndView blogItem(@PathVariable("id") Integer id,HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		NewsTemplete newsTemplete = newsTempleteService.get(id);
		
		map.put("newsTemplete", newsTemplete);
		
		ModelAndView mav = new ModelAndView("/views/front/page/news/newsTemplete/index", map);

		return mav;
	}
}
