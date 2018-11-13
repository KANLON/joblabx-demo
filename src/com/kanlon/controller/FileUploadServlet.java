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

import com.kanlon.bean.vo.FileResponseVO;
import com.kanlon.common.Constant;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JExcelOption;
import com.kanlon.common.JsonResponseUtil;
import com.kanlon.common.JsonResult;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.ResponseCode;
import com.kanlon.common.TimeUtil;
import com.kanlon.service.FileDataService;
import com.kanlon.service.FileDataServiceImpl;

/**
 * �ļ��ϴ���servlet��
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// �ϴ��ļ��洢Ŀ¼
	private static final String UPLOAD_DIRECTORY = Constant.WEB_APP_ROOT + "WEB-INF/" + "file/";

	// �ϴ�����
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * �ϴ����ݼ������ļ�
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonResult<FileResponseVO> result = new JsonResult<>();
		OutputStream out = response.getOutputStream();
		// ����Ƿ�Ϊ��ý���ϴ�
		if (!ServletFileUpload.isMultipartContent(request)) {
			result.setStateCode(ResponseCode.REQUEST_ERROR, "Error: ��������� enctype=multipart/form-data");
			// ���������ֹͣ
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			return;
		}

		// �����ϴ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// ������ʱ�洢Ŀ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// ��������ļ��ϴ�ֵ
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// �����������ֵ (�����ļ��ͱ�����)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// ���Ĵ���
		upload.setHeaderEncoding("UTF-8");

		// ������ʱ·�����洢�ϴ����ļ�
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = UPLOAD_DIRECTORY;

		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// ���������������ȡ�ļ�����
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// ����������
				for (FileItem item : formItems) {
					// �����ڱ��е��ֶ�
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						if (!fileName.endsWith("xlsx") && !fileName.endsWith("xls")) {
							result.setStateCode(ResponseCode.REQUEST_ERROR, "�ϴ����ļ�����excel����������ϴ���");
							out.write(JsonResponseUtil.getVOJsonStr(response, result));
							out.flush();
							return;
						}
						String filePath = uploadPath + TimeUtil.getLocalDateTime(System.currentTimeMillis())
								+ UUID.randomUUID().toString().substring(0, 4)
								+ fileName.substring(fileName.lastIndexOf("."));
						File storeFile = new File(filePath);
						// ����ļ����ϴ�·��
						LoggerUtil.logger.log(Level.INFO, "�ϴ����ļ�Ŀ¼Ϊ��" + filePath);
						// �����ļ���Ӳ��
						item.write(storeFile);
						// ��ȡexcel���
						List<ArrayList<String>> list = new ArrayList<>();
						try {
							list = JExcelOption.readExcel(filePath);
							LoggerUtil.logger.log(Level.INFO, list.toString());
						} catch (Exception e) {
							result.setStateCode(ResponseCode.RESPONSE_ERROR, "��ȡexcel����󣡣���" + e.getMessage());
							LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
							out.write(JsonResponseUtil.getVOJsonStr(response, result));
							out.flush();
							return;
						}
						// FileDataService service = new FileDataServiceImpl();
						// service.storeData(list);
						// // ��ȡ��ѧУ�͸��������
						// Map<String, String> mapYear =
						// service.getNumGroupByYear();
						// Map<String, String> mapSchool =
						// service.getNumGroupBySchool();
						// // ��װjson
						// FileResponseVO responseVo = new FileResponseVO();
						// responseVo.setMapSchool(mapSchool);
						// responseVo.setMapYear(mapYear);
						// result.setData(responseVo);
						// out.write(JsonResponseUtil.getVOJsonStr(response,
						// result));
						// out.flush();
						response.sendRedirect("year_and_school.html");
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
		// ��ת�� message.jsp
		// request.getServletContext().getRequestDispatcher("/").forward(request,
		// response);
		result.setStateCode(ResponseCode.REQUEST_ERROR, "�ϴ�ʧ�ܣ�");
		out.write(JsonResponseUtil.getVOJsonStr(response, result));
		return;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		JsonResult<FileResponseVO> result = new JsonResult<>();
		FileDataService service = new FileDataServiceImpl();
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			// // ��ȡ��ѧУ�͸��������
			// Map<String, String> mapYear = service.getNumGroupByYear();
			// Map<String, String> mapSchool = service.getNumGroupBySchool();
			// // ��װjson
			// FileResponseVO responseVo = new FileResponseVO();
			// responseVo.setMapSchool(mapSchool);
			// responseVo.setMapYear(mapYear);
			// result.setData(responseVo);
			// out.write(JsonResponseUtil.getVOJsonStr(response, result));
			// out.flush();
			response.sendRedirect("year_and_school.html");
		} catch (Exception e) {
			result.setStateCode(ResponseCode.RESPONSE_ERROR, e.getMessage());
			out.write(JsonResponseUtil.getVOJsonStr(response, result));
			out.flush();
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
		}
	}
}
