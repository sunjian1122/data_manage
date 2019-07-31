package com.alexgaoyh.admin.page.templete.portfolio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alexgaoyh.admin.page.templete.portfolio.util.RegexUtil;
import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * @desc 代表作品集-管理模板实体
 *
 * @author alexgaoyh
 * @Wed Oct 22 16:29:07 CST 2014
 */
@Entity
@Table(name="PORTFOLIO_TEMPLETE")
public class PortfolioTemplete extends BaseEntity{
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 类型
	 */
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name ="portfolioType_id")
	private PortfolioType portfolioType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PortfolioType getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(PortfolioType portfolioType) {
		this.portfolioType = portfolioType;
	}
	
	@Transient
	public String getSrcPart() {
		return RegexUtil.getHrefStrFromContent(this.content);
	}
	
	
}