package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanlon.bean.vo.FileResponseListVO;
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
public class DataYearAndSchoolListServlet extends HttpServlet {
	private static final long serialVersionUID = -7083540285559347423L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		JsonResult<FileResponseListVO> result = new JsonResult<>();
		FileDataService service = new FileDataServiceImpl();
		OutputStream out = null;

		try {
			out = response.getOutputStream();
			// ��ȡ��ѧУ�͸��������
			Map<String, String> mapYear = service.getNumGroupByYear();
			Map<String, String> mapSchool = service.getNumGroupBySchool();
			// ��װJSON
			FileResponseListVO responseVo = new FileResponseListVO();
			List<String> yearList = new ArrayList<>();
			List<String> yearNumList = new ArrayList<>();
			List<String> schoolList = new ArrayList<>();
			List<String> schoolNumList = new ArrayList<>();
			if (mapYear != null && mapYear.size() > 0) {
				// ��ȡ��ݼ����������
				for (String key : mapYear.keySet()) {
					yearList.add(key);
					yearNumList.add(mapYear.get(key));
				}
			}
			if (mapSchool != null && mapSchool.size() > 1) {
				// ��ȡ��ѧУ����ѧУ����
				for (String key : mapSchool.keySet()) {
					schoolList.add(key);
					schoolNumList.add(mapSchool.get(key));
				}
			}
			responseVo.setSchoolList(schoolList);
			responseVo.setSchoolNumList(schoolNumList);
			responseVo.setYearList(yearList);
			responseVo.setYearNumList(yearNumList);
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
