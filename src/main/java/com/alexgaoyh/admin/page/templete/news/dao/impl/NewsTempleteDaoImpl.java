package com.alexgaoyh.admin.page.templete.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.alexgaoyh.admin.page.templete.news.dao.NewsTempleteDao;
import com.alexgaoyh.admin.page.templete.news.entity.NewsTemplete;
import com.alexgaoyh.common.dao.impl.BaseDaoImpl;

/**
 * 
 * @desc 新闻页面-管理模板dao接口实现类
 *
 * @author alexgaoyh
 * @Thu Oct 16 18:16:40 CST 2014
 */
@Repository
public class NewsTempleteDaoImpl extends BaseDaoImpl<NewsTemplete> implements NewsTempleteDao {
	
	
	/**
	 *增加缓存逻辑，在查询方法的时候，调用.setCacheable(true) 即可完成缓存逻辑
	 */
	@Override
	public int getRowCountByDetachedCriteria(DetachedCriteria condition) {
		Criteria criteria = condition.getExecutableCriteria(this.getSessionFactory().getCurrentSession());
		Long totalCount = (Long) criteria.setCacheable(true).setProjection(Projections.rowCount()).uniqueResult();
		return totalCount == null ? 0 : totalCount.intValue();
	}

	/**
	 *增加缓存逻辑，在查询方法的时候，调用.setCacheable(true) 即可完成缓存逻辑
	 */
	@Override
	public List<NewsTemplete> findByDetachedCriteria(DetachedCriteria condition, int page, int rows) {
		Criteria criteria = condition.getExecutableCriteria(this.getSessionFactory().getCurrentSession());
		criteria.setFirstResult((page - 1) * rows).setMaxResults(rows);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		return criteria.setCacheable(true).list();
	}
	
}
