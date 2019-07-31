package com.alexgaoyh.admin.phone.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alexgaoyh.admin.phone.entity.Phone;
import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.common.util.Pagination;
import com.alexgaoyh.common.util.PhoneCheckUtil;
import com.alexgaoyh.common.vo.Data;
import com.alexgaoyh.common.vo.Result;

/**
 * 
 * 手机管理action控制类
 *
 * @author sj
 */
@SuppressWarnings("deprecation")
@Controller
@RequestMapping(value = "admin/page/phone")
public class PhoneAction extends BaseController<Phone> {

	private static final Logger LOGGER = Logger.getLogger(PhoneAction.class);

	@Override
	@Resource(name = "phoneServiceImpl")
	public void setBaseService(BaseService<Phone> baseService) {
		this.baseService = baseService;
	}

	/**
	 * 查询
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public void query(HttpServletRequest request, HttpServletResponse response) {

		try {
			String page = request.getParameter("page");// easyui datagrid 分页 页号
			String rows = request.getParameter("rows");// easyui datagrid 分页 页数

			// 搜索的内容
			String queryContent = request.getParameter("queryContent");
			DetachedCriteria condition = DetachedCriteria.forClass(Phone.class);
			decorateCondition(condition);
			if (StringUtils.isNotBlank(queryContent)) {
				condition.add(Restrictions.ilike("phone", queryContent.trim(),
						MatchMode.ANYWHERE));
			}
			condition.addOrder(Order.desc("createTime"));

			Pagination<Phone> pagination = this.getBaseService().getPageData(
					condition, Integer.parseInt(page), Integer.parseInt(rows));

			Data<Phone> data = new Data<Phone>(pagination);

			this.renderJson(data, response);
		} catch (NumberFormatException e) {
			LOGGER.error("admin/page/phone/query" + e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error("admin/page/phone/query" + e.getMessage(), e);
		}
	}
	
	/**
	 * 上传
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "upload")
	@ResponseBody
	public Result upload(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		if (!file.isEmpty()) {
			try {
				InputStream in = file.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line = "";
				List<String> phones = new ArrayList<>();
				while ((line = br.readLine()) != null) {
					phones.add(line);
				}
				br.close();
				isr.close();
				in.close();
				for(String phone : phones) {
					if(!PhoneCheckUtil.isMobile(phone)) {
						//若不是手机号，则过滤掉
						continue;
					}
					DetachedCriteria condition = DetachedCriteria.forClass(Phone.class);
					decorateCondition(condition);
					condition.add(Expression.eq("phone", phone));
					Pagination<Phone> pagination = this.getBaseService().getPageData(
							condition, 1, 1);
					if(pagination.getTotalCount() > 0) {
						//去重
						continue;
					}
					Phone savePhone = new Phone();
					savePhone.setPhone(phone);
					this.getBaseService().save(savePhone);
				}
			} catch (IOException e) {
				LOGGER.error("admin/page/phone/upload" + e.getMessage(), e);
				return Result.fail();
			} catch (Exception e) {
				LOGGER.error("admin/page/phone/upload" + e.getMessage(), e);
				return Result.fail();
			}
		}
		return Result.ok();
	}

}
