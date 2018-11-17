package com.kanlon.common;

import java.util.ArrayList;
import java.util.List;

import com.github.crab2died.ExcelUtils;
import com.kanlon.bean.ExcelObject;

/**
 * 利用poi操作excel表格的工具类
 *
 * @author zhangcanlong
 * @date 2018年11月14日
 */
public class ExcelPOIUtil {

	/**
	 * 读取excel表格内容，从第二行开始读起，默认去掉了表标题
	 *
	 * @param filePath
	 *            excel表格路径
	 * @return 返回嵌套list集合
	 * @throws Exception
	 */
	public static List<ArrayList<String>> excel2List(String filePath) throws Exception {
		// String filePath = "C:\\Users\\hasee\\Desktop\\热身赛数据集.xls";
		// 1)
		// 不基于注解,将Excel内容读至List<List<String>>对象内
		List<List<String>> lists = ExcelUtils.getInstance().readExcel2List(filePath, 1, 1000 * 1000, 0);
		// 2)
		// 基于注解,将Excel内容读至List<Student2>对象内
		// 验证读取转换函数Student2ExpelConverter
		// 注解 `@ExcelField(title = "是否开除", order = 5, readConverter =
		// Student2ExpelConverter.class)`
		// List<Student2> students =
		// ExcelUtils.getInstance().readExcel2Objects(path, Student2.class,
		// 0, 0);
		// System.out.println("读取Excel至对象数组(支持类型转换)：");
		// for (Student2 st : students) {
		// System.out.println(st);
		// }
		if (lists == null || lists.size() == 0) {
			return null;
		}
		List<ArrayList<String>> returnList = new ArrayList<>();

		for (List<String> list : lists) {
			ArrayList<String> innList = new ArrayList<>();
			innList = (ArrayList<String>) list;
			returnList.add(innList);
		}
		return returnList;
	}

	/**
	 * 读取excel表格内容到excel对象中，从第二行开始读起，默认去掉了表标题
	 *
	 * @param filePath
	 *            excel表格路径
	 * @return 返回嵌套list集合
	 * @throws Exception
	 */
	public static List<ExcelObject> excel2ExcelObject(String filePath) throws Exception {
		List<ExcelObject> excelObject = ExcelUtils.getInstance().readExcel2Objects(filePath, ExcelObject.class, 0, 0);
		if (excelObject == null || excelObject.size() == 0) {
			return null;
		}
		return excelObject;
	}

}
