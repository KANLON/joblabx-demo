package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanlon.bean.vo.SexNumVO;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.common.exception.BusinessException;
import com.kanlon.service.FileDataService;
import com.kanlon.service.FileDataServiceImpl;

/**
 * 得到男女比例数量的servlet
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class SexNumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonResult<SexNumVO> result = new JsonResult<>();
		OutputStream out = null;
		FileDataService service = new FileDataServiceImpl();
		try {
			out = response.getOutputStream();
			// 获取所有记录
			List<Integer> list = service.getNumGroupBySex();
			// 将数据封装到前端返回模板中
			SexNumVO sexNum = new SexNumVO();
			sexNum.setManNum("" + list.get(0));
			sexNum.setWomanNum("" + list.get(1));
			result.setData(sexNum);
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
