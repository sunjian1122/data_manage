package com.alexgaoyh.admin.page.templete.portfolio.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.admin.page.templete.portfolio.dao.PortfolioTypeDao;
import com.alexgaoyh.admin.page.templete.portfolio.entity.PortfolioType;
import com.alexgaoyh.admin.page.templete.portfolio.service.PortfolioTypeService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 代表作品集_类型-管理模板service接口实现类
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:08:35 CST 2014
 */
@Service
public class PortfolioTypeServiceImpl extends BaseServiceImpl<PortfolioType> implements PortfolioTypeService {

	@Override
	@Resource(name ="portfolioTypeDaoImpl")
	public void setBaseDao(BaseDao<PortfolioType> dao) {
		this.baseDao =  dao;
	}
	
	private PortfolioTypeDao getDao(){
		return (PortfolioTypeDao) this.baseDao ;
	}
	


}
