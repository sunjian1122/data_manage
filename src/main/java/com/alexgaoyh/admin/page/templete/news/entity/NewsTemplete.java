package com.alexgaoyh.admin.page.templete.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * @desc 新闻页面-管理模板实体
 *
 * @author alexgaoyh
 * @Thu Oct 16 18:16:40 CST 2014
 */
@Entity
@Table(name="NEWS_TEMPLETE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="newsTemplete")
public class NewsTemplete extends BaseEntity{
	
	/**
	 * 模板名称
	 */
	private String name;
	
	/**
	 * 模板内容
	 */
	@Column(length=16777216)
	private String content;
	
	/**
	 * 标签
	 */
	private String tags;

	
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}