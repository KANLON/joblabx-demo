package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanlon.bean.vo.FileResponseVO;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.service.FileDataService;
import com.kanlon.service.FileDataServiceImpl;

/**
 * 各个学校和各个年份数据的获取
 *
 * @author zhangcanlong
 * @date 2018年11月13日
 */
public class DataYearAndSchoolServlet extends HttpServlet {
	private static final long serialVersionUID = -7083540285559347423L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		JsonResult<FileResponseVO> result = new JsonResult<>();
		FileDataService service = new FileDataServiceImpl();
		OutputStream out = null;

		try {
			out = response.getOutputStream();
			// 获取各学校和各年份人数
			Map<String, String> mapYear = service.getNumGroupByYear();
			Map<String, String> mapSchool = service.getNumGroupBySchool();
			// 封装json
			FileResponseVO responseVo = new FileResponseVO();
			responseVo.setMapSchool(mapSchool);
			responseVo.setMapYear(mapYear);
			result.setData(responseVo);
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
		} catch (Exception e) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, e.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
