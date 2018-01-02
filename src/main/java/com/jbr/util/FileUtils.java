package com.jbr.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.jbr.exception.ServiceException;

public class FileUtils {

	public static void writeToFile(String path, List<String> commands) {
		File file = new File(path);
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(file);
			writer = new BufferedWriter(fw);
			for (String str : commands) {
				writer.write(str);
				writer.newLine();// 换行
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("写bat文件出错：" + e.getMessage());
		} finally {
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
