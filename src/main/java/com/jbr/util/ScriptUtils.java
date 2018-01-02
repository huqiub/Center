package com.jbr.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.jbr.constant.Constants;
import com.jbr.entity.ScriptEntity;

public class ScriptUtils {

	public static List<Integer> loginIdList;
	public static List<Integer> otherIdList;

	public static String scriptLocation;

	private static String target = "start, end";

	public static void operation(String path, List<ScriptEntity> list, int id) {
		File file = new File(path);
		opeationDirectory(file, list, id);
	}

	private static void opeationDirectory(File dir, List<ScriptEntity> list, int id) {

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.isDirectory()) {
				opeationDirectory(file, list, id);
			}
			if (file.isFile()) {
				int start = 40000;
				int offset = 10000;
				for (int j = 0; j < 10; j++) {
					ScriptEntity script = new ScriptEntity();
					script.setId(id);
					script.setPlayTime(start);
					String newContent = String.valueOf(start) + ", " + String.valueOf(start + offset);
					operationFile(file, script, newContent);

					start += offset;
					id++;
					list.add(script);
				}
			}
		}
	}

	private static void operationFile(File file, ScriptEntity script, String newContent) {

		try {
			InputStream is = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String filename = file.getName();
			if (filename.startsWith("1")) {
				script.setType(Constants.OPERATION_LOGIN);
			} else if (filename.startsWith("2")) {
				script.setType(Constants.OPERATION_OTHER);
			}
			// tmpfile为缓存文件，代码运行完毕后此文件将重命名为源文件名字。
			File tmpfile = new File(
					file.getParentFile().getParentFile().getAbsolutePath() + "\\new\\" + filename + ".tmp");

			String newFileName = script.getId() + "_play.lua";
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpfile));

			String str = null;
			int count = 0;
			while (true) {
				str = reader.readLine();

				if (str == null) {
					break;
				}
				if (str.contains("comment")) {
					String comment = str.substring(str.indexOf(":") + 1);
					script.setComment(comment);
				}

				if (str.contains(target)) {
					if (count == 0) {
						writer.write(str.replaceAll(target, newContent) + "\n");
					} else {
						newContent = String.valueOf(5000) + ", " + String.valueOf(150000);
						writer.write(str.replaceAll(target, newContent) + "\n");
					}
				} else {
					writer.write(str + "\n");
				}
			}

			is.close();

			writer.flush();
			writer.close();
			script.setLocation(scriptLocation + newFileName + ".E3");
			tmpfile.renameTo(new File(tmpfile.getParentFile().getAbsolutePath() + "\\" + newFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
