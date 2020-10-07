package model;

public class Password {
	private String pwdtitle;
	private String pwd;
	private Integer id;
	
	public Password(Integer id, String pwdtitle, String pwd) {
		super();
		this.pwdtitle = pwdtitle;
		this.pwd = pwd;
		this.id = id;
	}
	
	public Password(String pwdtitle, String pwd) {
		super();
		this.pwdtitle = pwdtitle;
		this.pwd = pwd;
	}
	
	public Password() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPwdtitle() {
		return pwdtitle;
	}
	public void setPwdtitle(String pwdtitle) {
		this.pwdtitle = pwdtitle;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
