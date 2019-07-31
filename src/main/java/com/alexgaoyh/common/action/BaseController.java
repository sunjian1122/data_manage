package com.alexgaoyh.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.common.util.JsonUtil;
import com.alexgaoyh.common.util.Pagination;
import com.alexgaoyh.common.vo.Data;
import com.alexgaoyh.common.vo.Result;
import com.alexgaoyh.util.GenericUtil;

public abstract class BaseController<E extends BaseEntity> {
	
	protected BaseService<E> baseService;
	
	private Class<E> entityClass;
	
	public abstract void setBaseService(BaseService<E> baseService);

	public BaseService<E> getBaseService() {
		return baseService;
	}
	
	@SuppressWarnings("unchecked")
	public BaseController() {
		try {
			entityClass = GenericUtil.getActualClass(this.getClass(), 0);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * 后台list页面
	 * 如请求地址为：   	http://localhost:8080/web/sysmanRole/list
	 * 则返回的页面应该在    /web/WEB-INF/views/sysmanRole/list.jsp
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		RequestMapping rm = this.getClass().getAnnotation(RequestMapping.class);
		String moduleName = "";
		if (rm != null) {
			String[] values = rm.value();
			if (ArrayUtils.isNotEmpty(values)) {
				moduleName = values[0];
			}
		}
		if (moduleName.endsWith("/")) {
			moduleName = moduleName.substring(0, moduleName.length() - 1);
		}
		
		model.setViewName("views/" + moduleName + "/list");
		model.addObject("moduleName", moduleName);
		return model;
	}
	
	/**
	 * 后台页面渲染easyui-datagrid 方法
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="getData")
    @ResponseBody
	public void getData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String page = request.getParameter("page");//easyui datagrid 分页 页号
		String rows = request.getParameter("rows");//easyui datagrid 分页 页数
		
		DetachedCriteria condition = DetachedCriteria.forClass(this.entityClass);
		
		decorateCondition(condition);
		
		Pagination<E> pagination = this.getBaseService().getPageData(condition,Integer.parseInt(page), Integer.parseInt(rows));
		
		Data<E> data = new Data<E>(pagination);
		
		this.renderJson(data, response);
	}
	
	/**
	 * 过滤属性集合
	 * @param condition
	 */
	protected void decorateCondition(DetachedCriteria condition) {
		condition.add(Expression.eq("deleteFlag", BaseEntity.DELETE_FLAG_NO));
	}
	
	/**
	 * json 化
	 * @param data
	 * @param response
	 * @throws IOException
	 */
	public void renderJson(Object data, HttpServletResponse response) throws  IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(JsonUtil.object2String(data)) ;
		writer.flush();
	}
	
	/**
	 * 保存
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="doSave")
    @ResponseBody
	public String doSave(HttpServletRequest request, HttpServletResponse response, E entity) throws IOException  {
		Result result = null;
		try {
			beforeDoSave(request, entity);
			this.getBaseService().save(entity);
			afterDoSave(request, entity);
			result = new Result(true, "保存成功！");
		} catch (Exception e) {
			result = new Result(false, "保存失败！"+e.getMessage());
		} finally {
			this.renderJson(result, response);
		}

		return null;
	}

	/**
	 * 调用保存方法之前进行的方法调用
	 * @param request
	 * @param entity 对应实体信息
	 * @throws Exception
	 */
	protected void beforeDoSave(HttpServletRequest request, E entity) throws Exception {
		
	}
	
	/**
	 * 电泳保存方法之后进行的方法调用
	 * @param request
	 * @param entity 对应实体信息
	 * @throws Exception
	 */
	protected void afterDoSave(HttpServletRequest request, E entity) throws Exception {
		
	}
	
	/**
	 * 更新
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="doUpdate")
    @ResponseBody
	public String doUpdate(HttpServletRequest request, HttpServletResponse response, E entity) throws IOException {
		Result result = null;
		try {
			beforeDoUpdate(request, entity);
			this.getBaseService().update(entity);
			afterDoUpdate(request, entity);
			result = new Result(true, "更新成功！");
		} catch (Exception e) {
			result = new Result(false, "更新失败！"+e.getMessage());
		} finally {
			this.renderJson(result, response);
		}
		return null;
	}

	/**
	 * 调用更新操作之前进行的操作
	 * @param request
	 * @param entity
	 * @throws Exception
	 */
	protected void beforeDoUpdate(HttpServletRequest request, E entity) throws Exception {
		
	}
	
	/**
	 * 调用更新操作之后进行的操作
	 * @param request
	 * @param entity
	 * @throws Exception
	 */
	protected void afterDoUpdate(HttpServletRequest request, E entity) throws Exception {
		
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="logicDelete")
    @ResponseBody
	public String logicDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Result result = null;
		try {
			String pids = request.getParameter("pids");
			if (pids != null) {
				this.getBaseService().deleteLogicByIds(pids.split("::"));
				result = new Result(true, "删除成功！");
			} else {
				result = new Result(false, "没有参数，非法操作！");
			}
		} catch (Exception e) {
			result = new Result(false, "更新失败！"+e.getMessage());
		} finally {
			this.renderJson(result, response);
		}
		return null;
	}

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

}
