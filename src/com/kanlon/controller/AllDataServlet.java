package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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

/**
 * 返回所有数据记录
 *
 * @author zhangcanlong
 * @date 2018年11月16日
 */
public class AllDataServlet extends HttpServlet {

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
			// 获取请求参数
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			// 获取所有记录
			List<ArrayList<String>> lists = service.getAllData(pageIndex, pageSize);
			// 获取所有记录数量
			num = service.getAllDataNum();
			// 将数据封装到前端返回模板中
			List<AllDataResponseVO> responseList = new ArrayList<>();
			if (lists != null && lists.size() >= 0) {
				for (ArrayList<String> tempList : lists) {
					AllDataResponseVO dataVo = new AllDataResponseVO();
					dataVo.setSex(tempList.get(1));
					dataVo.setSchool(tempList.get(2));
					dataVo.setDepartment(tempList.get(3));
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
