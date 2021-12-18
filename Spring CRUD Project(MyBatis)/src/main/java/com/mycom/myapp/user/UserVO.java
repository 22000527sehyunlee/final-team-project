package com.mycom.myapp.user;
public class UserVO {
	
	private String userid;
	private String password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	@Override
	public boolean equals(Object o) {
		return userid.equals(((UserVO)o).getUserid()) && password.equals(((UserVO)o).getPassword());
	}
	
}

