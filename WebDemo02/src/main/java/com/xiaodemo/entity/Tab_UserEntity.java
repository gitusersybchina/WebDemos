package com.xiaodemo.entity;

public class Tab_UserEntity extends IdEntity {

	private String name;
	private String pass;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tab_UserEntity [name=" + name + ", pass=" + pass + ", email=" + email + ", id=" + id + "]";
	}

}

