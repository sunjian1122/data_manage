package com.alexgaoyh.admin.page.templete.portfolio.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.admin.page.templete.portfolio.dao.PortfolioTempleteDao;
import com.alexgaoyh.admin.page.templete.portfolio.entity.PortfolioTemplete;
import com.alexgaoyh.admin.page.templete.portfolio.service.PortfolioTempleteService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 代表作品集-管理模板service接口实现类
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:29:07 CST 2014
 */
@Service
public class PortfolioTempleteServiceImpl extends BaseServiceImpl<PortfolioTemplete> implements PortfolioTempleteService {

	@Override
	@Resource(name ="portfolioTempleteDaoImpl")
	public void setBaseDao(BaseDao<PortfolioTemplete> dao) {
		this.baseDao =  dao;
	}
	
	private PortfolioTempleteDao getDao(){
		return (PortfolioTempleteDao) this.baseDao ;
	}
	


}
