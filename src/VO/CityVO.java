package VO;

import java.io.Serializable;

public class CityVO implements Serializable {
	
	private int cityID;
	private String cityName;
	private StateVO statevo;
	private String deleteStatus;
	
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public StateVO getStatevo() {
		return statevo;
	}
	public void setStatevo(StateVO statevo) {
		this.statevo = statevo;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

}
