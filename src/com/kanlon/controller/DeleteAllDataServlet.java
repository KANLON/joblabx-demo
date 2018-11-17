package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.dao.DataDao;

/**
 * 删除所有数据
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class DeleteAllDataServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -9095895479600995432L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		JsonResult<String> result = new JsonResult<>();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			DataDao dao = new DataDao();
			dao.truncateAllData();
			response.sendRedirect("all_data.html");
		} catch (Exception e) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, e.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
		}

	}
}
