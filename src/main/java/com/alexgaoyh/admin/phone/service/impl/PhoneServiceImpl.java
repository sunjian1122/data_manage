package com.alexgaoyh.admin.phone.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.admin.phone.dao.PhoneDao;
import com.alexgaoyh.admin.phone.entity.Phone;
import com.alexgaoyh.admin.phone.service.PhoneService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * 手机管理service接口实现类
 *
 * @author sj
 */
@Service
public class PhoneServiceImpl extends BaseServiceImpl<Phone> implements PhoneService {

	@Override
	@Resource(name ="phoneDaoImpl")
	public void setBaseDao(BaseDao<Phone> dao) {
		this.baseDao =  dao;
	}
	
	@SuppressWarnings("unused")
	private PhoneDao getDao(){
		return (PhoneDao) this.baseDao ;
	}
	


}
