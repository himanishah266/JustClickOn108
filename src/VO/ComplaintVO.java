package VO;

public class ComplaintVO {

	private int cid;
	private String ctitle;
	private String cdesc;
	private String creply;
	private LoginVO complaintFrom;
	private LoginVO complaintTo;
	private String complaintDate;
	private String complaintTime;
	private String complaintStatus;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCreply() {
		return creply;
	}
	public void setCreply(String creply) {
		this.creply = creply;
	}
	public LoginVO getComplaintFrom() {
		return complaintFrom;
	}
	public void setComplaintFrom(LoginVO complaintFrom) {
		this.complaintFrom = complaintFrom;
	}
	public LoginVO getComplaintTo() {
		return complaintTo;
	}
	public void setComplaintTo(LoginVO complaintTo) {
		this.complaintTo = complaintTo;
	}
	
	public String getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getComplaintTime() {
		return complaintTime;
	}
	public void setComplaintTime(String complaintTime) {
		this.complaintTime = complaintTime;
	}
	public String getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

}
