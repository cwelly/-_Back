package com.ssafy.passproject.dto;

public class Case {
	// 사고 기록들을 저장하는 DTO
////	caseno bigint AI PK  
//	사고 번호
	private int caseno;
////	sidogugun varchar(40)
//	시도 구군 정보
	private String sidogugun; 
////	adress varchar(100)
//	상세 주소
	private String adress;
////	casedate date
//	사고 날짜
	private String casedate;
////	casehour int
//	사고 시간
	private int casehour;
////	level varchar(10)
//	사고 정도
	private String level;
////	persex varchar(10)
//	가해자 성별
	private String persex;
////	perage int
//	가해자 나이
	private int perage;
////	pertrans varchar(20)
//	가해자 교통수단
	private String pertrans;
////	perdamage varchar(20)
//	가해자 피해 정도
	private String perdamage;
////	vicsex varchar(10)
//	피해자 성별
	private String vicsex;
////	vicage int
//	피해자 나이
	private int vicage;
////	victrans varchar(20)
//	피해자 교통수단
	private String victrans;
////	vicdamage varchar(20)
//	피해자 피해 정도
	private String vicdamage;
////	casetype varchar(30) 
//	사고 유형
	private String casetype;
////	caseissue varchar(30)
//	사고 원인
	private String caseissue;
////	deadcnt int
//	사망자 수
	private int deadcnt;
////	hurtcnt int
//	부상자 수
	private int hurtcnt;
////	lat varchar(30)
//	lat
	private String lat;
////	lng varchar(30)
//	lng
	private String lng;
	
	//생성자
	public Case() {
		
	}
	
	public Case(int caseno, String sidogugun, String adress, String casedate, int casehour, String level, String persex,
			int perage, String pertrans, String perdamage, String vicsex, int vicage, String victrans, String vicdamage,
			String casetype, String caseissue, int deadcnt, int hurtcnt, String lat, String lng) {
		super();
		this.caseno = caseno;
		this.sidogugun = sidogugun;
		this.adress = adress;
		this.casedate = casedate;
		this.casehour = casehour;
		this.level = level;
		this.persex = persex;
		this.perage = perage;
		this.pertrans = pertrans;
		this.perdamage = perdamage;
		this.vicsex = vicsex;
		this.vicage = vicage;
		this.victrans = victrans;
		this.vicdamage = vicdamage;
		this.casetype = casetype;
		this.caseissue = caseissue;
		this.deadcnt = deadcnt;
		this.hurtcnt = hurtcnt;
		this.lat = lat;
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Case [caseno=" + caseno + ", sidogugun=" + sidogugun + ", adress=" + adress + ", casedate=" + casedate
				+ ", casehour=" + casehour + ", level=" + level + ", persex=" + persex + ", perage=" + perage
				+ ", pertrans=" + pertrans + ", perdamage=" + perdamage + ", vicsex=" + vicsex + ", vicage=" + vicage
				+ ", victrans=" + victrans + ", vicdamage=" + vicdamage + ", casetype=" + casetype + ", caseissue="
				+ caseissue + ", deadcnt=" + deadcnt + ", hurtcnt=" + hurtcnt + ", lat=" + lat + ", lng=" + lng + "]";
	}

	public int getCaseno() {
		return caseno;
	}

	public void setCaseno(int caseno) {
		this.caseno = caseno;
	}

	public String getSidogugun() {
		return sidogugun;
	}

	public void setSidogugun(String sidogugun) {
		this.sidogugun = sidogugun;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCasedate() {
		return casedate;
	}

	public void setCasedate(String casedate) {
		this.casedate = casedate;
	}

	public int getCasehour() {
		return casehour;
	}

	public void setCasehour(int casehour) {
		this.casehour = casehour;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPersex() {
		return persex;
	}

	public void setPersex(String persex) {
		this.persex = persex;
	}

	public int getPerage() {
		return perage;
	}

	public void setPerage(int perage) {
		this.perage = perage;
	}

	public String getPertrans() {
		return pertrans;
	}

	public void setPertrans(String pertrans) {
		this.pertrans = pertrans;
	}

	public String getPerdamage() {
		return perdamage;
	}

	public void setPerdamage(String perdamage) {
		this.perdamage = perdamage;
	}

	public String getVicsex() {
		return vicsex;
	}

	public void setVicsex(String vicsex) {
		this.vicsex = vicsex;
	}

	public int getVicage() {
		return vicage;
	}

	public void setVicage(int vicage) {
		this.vicage = vicage;
	}

	public String getVictrans() {
		return victrans;
	}

	public void setVictrans(String victrans) {
		this.victrans = victrans;
	}

	public String getVicdamage() {
		return vicdamage;
	}

	public void setVicdamage(String vicdamage) {
		this.vicdamage = vicdamage;
	}

	public String getCasetype() {
		return casetype;
	}

	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}

	public String getCaseissue() {
		return caseissue;
	}

	public void setCaseissue(String caseissue) {
		this.caseissue = caseissue;
	}

	public int getDeadcnt() {
		return deadcnt;
	}

	public void setDeadcnt(int deadcnt) {
		this.deadcnt = deadcnt;
	}

	public int getHurtcnt() {
		return hurtcnt;
	}

	public void setHurtcnt(int hurtcnt) {
		this.hurtcnt = hurtcnt;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
	
}

