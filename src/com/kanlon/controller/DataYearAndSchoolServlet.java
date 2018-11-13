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
 * ����ѧУ�͸���������ݵĻ�ȡ
 *
 * @author zhangcanlong
 * @date 2018��11��13��
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
			// ��ȡ��ѧУ�͸��������
			Map<String, String> mapYear = service.getNumGroupByYear();
			Map<String, String> mapSchool = service.getNumGroupBySchool();
			// ��װjson
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
