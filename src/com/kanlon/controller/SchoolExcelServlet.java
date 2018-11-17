package com.kanlon.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.github.crab2died.ExcelUtils;
import com.kanlon.bean.SchoolExcelObject;
import com.kanlon.common.Constant;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.common.TimeUtil;
import com.kanlon.service.SchoolDataService;

/**
 * 导入学校的excel表
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class SchoolExcelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = Constant.WEB_APP_ROOT + "WEB-INF/" + "schoolfile/";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * 上传数据及保存文件
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonResult<String> result = new JsonResult<>();
		OutputStream out = response.getOutputStream();
		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			result.setStateCode(ResponseCode.REQUEST_ERROR, "Error: 表单必须包含 enctype=multipart/form-data");
			// 如果不是则停止
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		String uploadPath = UPLOAD_DIRECTORY;

		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// 解析请求的内容提取文件数据
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						if (!fileName.endsWith("xlsx") && !fileName.endsWith("xls")) {
							result.setStateCode(ResponseCode.REQUEST_ERROR, "上传的文件不是excel表格，请重新上传！");
							out.write(JsonResponseUtil.getVOJsonStr(response, result));
							out.flush();
							return;
						}
						String filePath = uploadPath + TimeUtil.getLocalDateTime(System.currentTimeMillis())
								+ UUID.randomUUID().toString().substring(0, 4)
								+ fileName.substring(fileName.lastIndexOf("."));
						File storeFile = new File(filePath);
						// 输出文件的上传路径
						LoggerUtil.logger.log(Level.INFO, "上传的文件目录为：" + filePath);
						// 保存文件到硬盘
						item.write(storeFile);
						// 读取excel表格
						List<SchoolExcelObject> objects = new ArrayList<>();
						try {

							objects = ExcelUtils.getInstance().readExcel2Objects(filePath, SchoolExcelObject.class);
							LoggerUtil.logger.log(Level.INFO, "读取excel的数据:" + objects.toString());
							// 将其存储到数据库中去
							SchoolDataService service = new SchoolDataService();
							service.stroeSchoolData(objects);
						} catch (Exception e) {
							result.setStateCode(ResponseCode.RESPONSE_ERROR, "读取excel表错误！！！" + e.getMessage());
							LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
							// out.write(JsonResponseUtil.getVOJsonStr(response,
							// result));
							response.sendRedirect("file_error.html");
							out.flush();
							return;
						}
						response.sendRedirect("file_success.html");
						return;
					}
				}
			}
		} catch (Exception ex) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, ex.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(ex));
		}
		// 跳转到 message.jsp
		// request.getServletContext().getRequestDispatcher("/").forward(request,
		// response);
		result.setStateCode(ResponseCode.REQUEST_ERROR, "上传失败！");
		out.write(JsonResponseUtil.getVOJsonStr(response, result));
		return;
	}

}
