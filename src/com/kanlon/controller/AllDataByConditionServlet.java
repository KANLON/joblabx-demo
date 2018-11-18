package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanlon.bean.vo.AllDataResponseVO;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.common.exception.BusinessException;
import com.kanlon.service.FileDataService;
import com.kanlon.service.FileDataServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * 通过某些条件返回所有数据记录
 *
 * @author zhangcanlong
 * @date 2018年11月16日
 */
public class AllDataByConditionServlet extends HttpServlet {

	private static final long serialVersionUID = -6353359007777843387L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonResult<List<AllDataResponseVO>> result = new JsonResult<>();
		OutputStream out = null;
		FileDataService service = new FileDataServiceImpl();
		int num = 0;
		try {
			out = response.getOutputStream();

			String pageIndexStr = request.getParameter("pageIndex");
			String pageSizeStr = request.getParameter("pageSize");
			// 学校
			String school = request.getParameter("school");
			// 入学年份
			String year = request.getParameter("year");
			// 城市
			String city = request.getParameter("city");
			if (StringUtils.isNullOrEmpty(pageSizeStr) || StringUtils.isNullOrEmpty(pageIndexStr)) {
				result.setStateCode(ResponseCode.REQUEST_ERROR, "pageIndex或pageSize为null或null字符串");
				out.write(JsonResponseUtil.getVOJsonStr(response, result));
				out.flush();
				return;
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("school", school);
			paramMap.put("year", year);
			paramMap.put("city", city);

			// 获取请求参数
			int pageIndex = Integer.parseInt(pageIndexStr);
			int pageSize = Integer.parseInt(pageSizeStr);
			if (StringUtils.isNullOrEmpty(city) && StringUtils.isNullOrEmpty(year)
					&& StringUtils.isNullOrEmpty(school)) {
				response.sendRedirect("all_data?pageIndex=" + pageIndex + "&pageSize=" + pageSize);
				return;
			}

			// 获取所有记录
			List<ArrayList<String>> lists = service.getAllDataByCondition(paramMap, pageIndex, pageSize);
			// 获取所有记录数量
			num = service.getAllDataNumByCondition(paramMap);
			// 将数据封装到前端返回模板中
			List<AllDataResponseVO> responseList = new ArrayList<>();
			if (lists != null && lists.size() >= 0) {
				for (ArrayList<String> tempList : lists) {
					AllDataResponseVO dataVo = new AllDataResponseVO();
					dataVo.setSex(tempList.get(1));
					dataVo.setSchool(tempList.get(2));
					dataVo.setDepartment(tempList.get(3) == null ? "" : tempList.get(3));
					dataVo.setYear(tempList.get(4));
					dataVo.setjValue(tempList.get(5));
					responseList.add(dataVo);
				}
			}
			result.setData(responseList);
			result.setMsg("" + num);
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
		} catch (BusinessException e) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, e.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
		}

	}
}
