package himedia.dvd.repositories.vo;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserVo {
	private Long userNo; // 怨좎쑀 踰덊샇
	
	@NotEmpty
	private String username; // �씠由�
	
	@NotEmpty
	private String birth; // �깮�씪
	
	@NotEmpty
	private String email; // �씠硫붿씪
	
	@NotEmpty
	private String password; // 鍮꾨쾲
	
	@NotEmpty
	private String passwordConfirm;	// 鍮꾨쾲 �솗�씤
	
	
	private Date regdate; // 媛��엯�궇吏�
	
	private int role; // �쉶�썝援щ텇
	
	@NotNull
	private Boolean agree; // �빟愿� �룞�쓽 �뿬遺�

	// 湲곕낯�깮�꽦�옄
	public UserVo() {

	}

	public UserVo(Long userNo, String username, String birth, String email, String password, String passwordConfirm, Date regdate, int role, Boolean agree) {
		super();
		this.userNo = userNo;
		this.username = username;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.regdate = regdate;
		this.role = role;
		this.agree = agree;
	}

	// �쉶�썝媛��엯�뿉 �븘�슂�븳 �깮�꽦�옄
	public UserVo(String username, String email, String birth, String password, String passwordConfirm, Boolean agree) {
		this.username = username;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.agree = agree;
	}
	
	// �쉶�썝�젙蹂댁닔�젙�뿉 �븘�슂�븳 �깮�꽦�옄
	public UserVo(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Boolean getAgree() {
		return agree;
	}

	public void setAgree(Boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", username=" + username + ", birth=" + birth + ", email=" + email
				+ ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", regdate=" + regdate + ", role="
				+ role + ", agree=" + agree + "]";
	}
}
