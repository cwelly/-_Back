package com.ssafy.passproject.dto;

public class MapInfo {
	//거래날짜, 아파트 코드, 층 , 면적,  아파트 이름, 건축일자 , 위도(lat ) , 경도(lng)  , 지번 , 거래금액
	//거래금액
	private String apartmentName;
	private String buildYear;
	private String area;
	private String dong;
	private String jibun;
	private String dealAmount;
	private String sido;
	private String gugun;
	
	public MapInfo() {
		super();
	}
	public MapInfo(String apartmentName, String buildYear, String area, String dong, String jibun, String dealAmount,
			String sido, String gugun) {
		super();
		this.apartmentName = apartmentName;
		this.buildYear = buildYear;
		this.area = area;
		this.dong = dong;
		this.jibun = jibun;
		this.dealAmount = dealAmount;
		this.sido = sido;
		this.gugun = gugun;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	@Override
	public String toString() {
		return "MapInfo [apartmentName=" + apartmentName + ", buildYear=" + buildYear + ", area=" + area + ", dong="
				+ dong + ", jibun=" + jibun + ", dealAmount=" + dealAmount + ", sido=" + sido + ", gugun=" + gugun
				+ "]";
	}

}
