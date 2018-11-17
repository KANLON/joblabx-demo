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
 * 获取学校参赛人数数量排名前5的学校和数量
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class Top5NumSchoolServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		JsonResult<FileResponseListVO> result = new JsonResult<>();
		FileDataService service = new FileDataServiceImpl();
		OutputStream out = null;

		try {
			out = response.getOutputStream();
			// 获取排名前五学校数量
			Map<String, String> mapSchool = service.getTop5NumGroupBySchool();
			// 封装JSON
			FileResponseListVO responseVo = new FileResponseListVO();
			List<String> schoolList = new ArrayList<>();
			List<String> schoolNumList = new ArrayList<>();
			if (mapSchool != null && mapSchool.size() > 1) {
				// 获取各学校及各学校数量
				for (String key : mapSchool.keySet()) {
					schoolList.add(key);
					schoolNumList.add(mapSchool.get(key));
				}
			}
			responseVo.setSchoolList(schoolList);
			responseVo.setSchoolNumList(schoolNumList);
			result.setData(responseVo);
			LoggerUtil.logger.log(Level.INFO, "返回前端的信息为：" + schoolList + "\r\t" + schoolNumList + "\r\t");
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
		} catch (Exception e) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, e.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
		}

	}
}
