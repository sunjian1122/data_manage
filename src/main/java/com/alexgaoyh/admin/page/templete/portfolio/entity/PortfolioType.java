package com.alexgaoyh.admin.page.templete.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * @desc 代表作品集_类型-管理模板实体
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:08:35 CST 2014
 */
@Entity
@Table(name="PORTFOLIO_TYPE")
public class PortfolioType extends BaseEntity{

	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 描述
	 * Describe desc  都是关键字,避免使用
	 */
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}