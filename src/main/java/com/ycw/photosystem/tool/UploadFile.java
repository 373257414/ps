/*
package com.ycw.photosystem.tool;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class UploadFile {

	public static Map<String, String> uploadFile(HttpServletRequest request, String path,String picName)
			throws Exception {
		Map<String,String> parameters = new HashMap<String, String>();
		File file = new File(path);
		int maxsize = 30;// �ļ����ֵΪ5M
		request.setCharacterEncoding("utf-8");
		if (!file.exists() && !file.isDirectory())
			file.mkdir();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(30 * 1024);
		factory.setRepository(factory.getRepository());
		ServletFileUpload upload = new ServletFileUpload(factory);
		List list = upload.parseRequest(request);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			FileItem item = (FileItem) iterator.next();
			if (!item.isFormField()) {
				String filePath = item.getName();
				if (filePath != null) {
					File filename = new File(item.getName());
				}
				if (item.getSize() > maxsize * 1024 * 1024) {
					return null;
				}
				File saveFile = new File(path, filePath);
				item.write(saveFile);
			}else {
				String name = item.getFieldName();
				String value = item.getString();
				parameters.put(name, value);
			}
		}
		return parameters;
	}
}
*/
