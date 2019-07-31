package com.alexgaoyh.admin.phone.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.alexgaoyh.admin.phone.dao.PhoneDao;
import com.alexgaoyh.admin.phone.entity.Phone;
import com.alexgaoyh.common.dao.impl.BaseDaoImpl;

/**
 * 
 * @desc 手机管理dao接口实现类
 *
 * @author sj
 */
@Repository
public class PhoneDaoImpl extends BaseDaoImpl<Phone> implements PhoneDao {
	
	
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> findByDetachedCriteria(DetachedCriteria condition, int page, int rows) {
		Criteria criteria = condition.getExecutableCriteria(this.getSessionFactory().getCurrentSession());
		criteria.setFirstResult((page - 1) * rows).setMaxResults(rows);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		return criteria.setCacheable(true).list();
	}
	
}
