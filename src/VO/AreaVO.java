package VO;

public class AreaVO {
	private int areaID;
	private String areaName;
	private String  areaDes;
	private StateVO statevo;
	private CityVO cityvo;
	private String deleteStatus;
	
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public StateVO getStatevo() {
		return statevo;
	}
	public void setStatevo(StateVO statevo) {
		this.statevo = statevo;
	}
	public CityVO getCityvo() {
		return cityvo;
	}
	public void setCityvo(CityVO cityvo) {
		this.cityvo = cityvo;
	}
	public String getAreaDes() {
		return areaDes;
	}
	public void setAreaDes(String areaDes) {
		this.areaDes = areaDes;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

}
