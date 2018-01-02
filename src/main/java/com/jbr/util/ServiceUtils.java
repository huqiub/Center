package com.jbr.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jbr.constant.Constants;
import com.jbr.exception.ServiceException;

public class ServiceUtils {

	public static String timeScale;
	public static String abtimeScale;

	public static int getScriptId(int isLogin) {
		List<Integer> ids = null;
		if (isLogin == Constants.IS_LOGIN) {
			ids = ScriptUtils.loginIdList;
		} else {
			ids = ScriptUtils.otherIdList;
		}
		if (!Utils.isEmptyList(ids)) {
			return ids.get(Utils.randomInt(1, ids.size()) - 1);
		} else {
			throw new ServiceException("没有相应的脚本存在!");
		}
	}

	public static int getOperation(int isLogin) {
		if (isLogin == Constants.IS_LOGIN) {
			return Constants.OPERATION_LOGIN;
		} else {
			return Constants.OPERATION_OTHER;
		}
	}

	public static boolean validImei(String imei) {
		if (!StringUtils.isEmpty(imei)) {
			int length = imei.length();
			if (length == 14 || length == 15) {
				return true;
			}
		}
		return false;
	}

	public static boolean validImsi(String imsi) {
		if (!StringUtils.isEmpty(imsi)) {
			if (StringUtils.startsWithIgnoreCase(imsi, "460")) {
				return true;
			}
		}
		return false;
	}

	public static String getTaskId() {
		return System.nanoTime() + String.valueOf((int) (Math.random() * 900) + 101);
	}

	/**
	 * 根据任务的时间分配比例和任务数，获取每各时间段执行任务的数量
	 * 
	 * @param totalCount
	 * @param queue
	 */
	public static void inferTimeQuantum(int totalCount, List<Integer> list, int abTime, boolean isBaseTime) {
		String[] timeQuantum = {};
		if (isBaseTime) {
			if (abTime == Constants.NORMAL_TIME) {
				timeQuantum = Arrays.copyOfRange(timeScale.split(","), 0, 20);
			} else {
				timeQuantum = abtimeScale.split(",");
			}
		} else {
			timeQuantum = timeScale.split(",");
		}
		for (int i = 0; i < timeQuantum.length; i++) {
			String[] time = timeQuantum[i].split(":");
			int count = Math.round((totalCount * ((float) Integer.valueOf(time[1]) / 100)));
			for (int j = 0; j < count; j++) {
				try {
					list.add(Integer.valueOf(time[0]));
				} catch (Exception e) {
					throw new ServiceException("计算时间段出现的次数出错：" + e.getMessage());
				}
			}
		}
	}

	public static Date getValidTime(String yearAndMonth, int day, List<Integer> list) {
		int year = Integer.valueOf(yearAndMonth.substring(0, yearAndMonth.indexOf("-")));
		int month = Integer.valueOf(yearAndMonth.substring(yearAndMonth.indexOf("-") + 1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);

		int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (day > actualMaximum) {
			int d = day - actualMaximum;
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, d);
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}
		int size = list.size();
		if (size != 0) {
			int randomIndex = Utils.randomInt(0, size - 1);
			int hour = list.get(randomIndex);
			calendar.set(Calendar.HOUR_OF_DAY, hour);
			list.remove(randomIndex);
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, Utils.randomInt(6, 23));
		}

		calendar.set(Calendar.MINUTE, Utils.randomInt(0, 59));
		calendar.set(Calendar.SECOND, Utils.randomInt(0, 59));
		return calendar.getTime();
	}

	public static Date getValidTimeByRandom(String yearAndMonth, int day) {
		int year = Integer.valueOf(yearAndMonth.substring(0, yearAndMonth.indexOf("-")));
		int month = Integer.valueOf(yearAndMonth.substring(yearAndMonth.indexOf("-") + 1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);

		int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (day > actualMaximum) {
			int d = day - actualMaximum;
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, d);
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}

		calendar.set(Calendar.HOUR_OF_DAY, Utils.randomInt(0, 23));
		calendar.set(Calendar.MINUTE, Utils.randomInt(0, 59));
		calendar.set(Calendar.SECOND, Utils.randomInt(0, 59));
		return calendar.getTime();
	}

	public static Date getInvalidTime(Date validDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(validDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 000);
		return calendar.getTime();
	}

	public static boolean checkDeviceIsEnough(int isBindCount, int notBindCount, int size, int size2) {
		if (size < isBindCount || size2 < notBindCount) {
			return false;
		}
		return true;
	}

	public static void execCommand(String path) throws Exception {
		Process process = Runtime.getRuntime().exec("cmd.exe /c start " + path);
		process.waitFor();
	}

}
