package com.alexgaoyh.admin.page.templete.news.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.admin.page.templete.news.dao.NewsTempleteDao;
import com.alexgaoyh.admin.page.templete.news.entity.NewsTemplete;
import com.alexgaoyh.admin.page.templete.news.service.NewsTempleteService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 新闻页面-管理模板service接口实现类
 *
 * @author alexgaoyh
 * @Thu Oct 16 18:16:40 CST 2014
 */
@Service
public class NewsTempleteServiceImpl extends BaseServiceImpl<NewsTemplete> implements NewsTempleteService {

	@Override
	@Resource(name ="newsTempleteDaoImpl")
	public void setBaseDao(BaseDao<NewsTemplete> dao) {
		this.baseDao =  dao;
	}
	
	private NewsTempleteDao getDao(){
		return (NewsTempleteDao) this.baseDao ;
	}
	


}
