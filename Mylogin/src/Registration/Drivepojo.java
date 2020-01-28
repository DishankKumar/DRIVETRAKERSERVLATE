package Registration;

import java.sql.Date;

public class Drivepojo {

	private int id;
	private String companyname;
	private int resource;
	private int exp;
	private int ctc;
	private int position;
	private int joining;
	private int education;
	private Date followup;
	private int bond;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public int getResource() {
		return resource;
	}
	public void setResource(int resource) {
		this.resource = resource;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getJoining() {
		return joining;
	}
	public void setJoining(int joining) {
		this.joining = joining;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public Date getFollowup() {
		return followup;
	}
	public void setFollowup(Date followup) {
		this.followup = followup;
	}
	public int getBond() {
		return bond;
	}
	public void setBond(int bond) {
		this.bond = bond;
	}

	
}
