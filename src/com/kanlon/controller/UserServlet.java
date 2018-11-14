package com.kanlon.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.kanlon.bean.User;
import com.kanlon.common.LoggerUtil;

/**
 *
 * 用户类的获取用户信息的请求操作
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 7142804512583167572L;

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setUsername("张三三");
		user.setPassword("123456");
		String userJson = JSON.toJSONString(user);
		OutputStream out = response.getOutputStream();
		out.write(userJson.getBytes("UTF-8"));
		out.flush();
		LoggerUtil.logger.log(Level.INFO, "项目启动，日志开始记录！");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
