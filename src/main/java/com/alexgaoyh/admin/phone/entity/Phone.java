package com.alexgaoyh.admin.phone.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * 手机信息
 *
 * @author sj
 * @date 2019/07/17 22:40
 */
@Entity
@Table(name="phone")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="phone")
public class Phone extends BaseEntity{
	
	private static final long serialVersionUID = 5817407028504818285L;

	/**
	 * 手机号码
	 */
	@Column(length=11)
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}