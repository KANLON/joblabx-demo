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
 * �û���Ļ�ȡ�û���Ϣ���������
 *
 * @author zhangcanlong
 * @date 2018��11��12��
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
		user.setUsername("������");
		user.setPassword("123456");
		String userJson = JSON.toJSONString(user);
		OutputStream out = response.getOutputStream();
		out.write(userJson.getBytes("UTF-8"));
		out.flush();
		LoggerUtil.logger.log(Level.INFO, "��Ŀ��������־��ʼ��¼��");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
