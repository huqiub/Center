package com.jbr.domain;

import java.io.Serializable;

public class Rule implements Serializable {

	private static final long serialVersionUID = 6547733362901134460L;

	private String month;
	private String channel;
	private float noLogin;
	private float activelyDays7;
	private float abTime;

	private int allSum;
	private int validSum;

	private int t000;
	private int t001;
	private int t010;
	private int t011;
	private int t100;
	private int t101;
	private int t110;
	private int t111;

	private String r000;
	private String r001;
	private String r010;
	private String r011;
	private String r100;
	private String r101;
	private String r110;
	private String r111;

	private String s000;
	private String s001;
	private String s010;
	private String s011;
	private String s100;
	private String s101;
	private String s110;
	private String s111;

	public int getAllSum() {
		this.allSum = t000 + t001 + t010 + t011 + t100 + t101 + t110 + t111;
		return allSum;
	}

	public void setAllSum(int allSum) {
		this.allSum = allSum;
	}

	public int getValidSum() {
		int v000 = getValidData(t000, r000);
		int v001 = getValidData(t001, r001);
		int v010 = getValidData(t010, r010);
		int v011 = getValidData(t011, r011);
		int v100 = getValidData(t100, r100);
		int v101 = getValidData(t101, r101);
		int v110 = getValidData(t110, r110);
		int v111 = getValidData(t111, r111);

		this.validSum = v000 + v001 + v010 + v011 + v100 + v101 + v110 + v111;
		return validSum;
	}

	private int getValidData(int t, String r) {
		if (r != null && !"".equals(r)) {
			return (int) Math.round(t * (1 - Float.valueOf(r.substring(0, r.length() - 1)) / 100));
		}
		return 0;
	}

	public void setValidSum(int validSum) {
		this.validSum = validSum;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public float getNoLogin() {
		return noLogin;
	}

	public void setNoLogin(float noLogin) {
		this.noLogin = noLogin;
	}

	public float getActivelyDays7() {
		return activelyDays7;
	}

	public void setActivelyDays7(float activelyDays7) {
		this.activelyDays7 = activelyDays7;
	}

	public float getAbTime() {
		return abTime;
	}

	public void setAbTime(float abTime) {
		this.abTime = abTime;
	}

	public int getT000() {
		return t000;
	}

	public void setT000(int t000) {
		this.t000 = t000;
	}

	public int getT001() {
		return t001;
	}

	public void setT001(int t001) {
		this.t001 = t001;
	}

	public int getT010() {
		return t010;
	}

	public void setT010(int t010) {
		this.t010 = t010;
	}

	public int getT011() {
		return t011;
	}

	public void setT011(int t011) {
		this.t011 = t011;
	}

	public int getT100() {
		return t100;
	}

	public void setT100(int t100) {
		this.t100 = t100;
	}

	public int getT101() {
		return t101;
	}

	public void setT101(int t101) {
		this.t101 = t101;
	}

	public int getT110() {
		return t110;
	}

	public void setT110(int t110) {
		this.t110 = t110;
	}

	public int getT111() {
		return t111;
	}

	public void setT111(int t111) {
		this.t111 = t111;
	}

	public String getR000() {
		return replaceNull(r000);
	}

	public void setR000(String r000) {
		this.r000 = r000;
	}

	public String getR001() {
		return replaceNull(r001);
	}

	public void setR001(String r001) {
		this.r001 = r001;
	}

	public String getR010() {
		return replaceNull(r010);
	}

	public void setR010(String r010) {
		this.r010 = r010;
	}

	public String getR011() {
		return replaceNull(r011);
	}

	public void setR011(String r011) {
		this.r011 = r011;
	}

	public String getR100() {
		return replaceNull(r100);
	}

	public void setR100(String r100) {
		this.r100 = r100;
	}

	public String getR101() {
		return replaceNull(r101);
	}

	public void setR101(String r101) {
		this.r101 = r101;
	}

	public String getR110() {
		return replaceNull(r110);
	}

	public void setR110(String r110) {
		this.r110 = r110;
	}

	public String getR111() {
		return replaceNull(r111);
	}

	public void setR111(String r111) {
		this.r111 = r111;
	}

	public String getS000() {
		return replaceNull(s000);
	}

	public void setS000(String s000) {
		this.s000 = s000;
	}

	public String getS001() {
		return replaceNull(s001);
	}

	public void setS001(String s001) {
		this.s001 = s001;
	}

	public String getS010() {
		return replaceNull(s010);
	}

	public void setS010(String s010) {
		this.s010 = s010;
	}

	public String getS011() {
		return replaceNull(s011);
	}

	public void setS011(String s011) {
		this.s011 = s011;
	}

	public String getS100() {
		return replaceNull(s100);
	}

	public void setS100(String s100) {
		this.s100 = s100;
	}

	public String getS101() {
		return replaceNull(s101);
	}

	public void setS101(String s101) {
		this.s101 = s101;
	}

	public String getS110() {
		return replaceNull(s110);
	}

	public void setS110(String s110) {
		this.s110 = s110;
	}

	public String getS111() {
		return replaceNull(s111);
	}

	public void setS111(String s111) {
		this.s111 = s111;
	}

	private String replaceNull(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}
}
