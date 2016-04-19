package com.company.mybatis.pojo;

import java.util.Date;

/**
 * <p> Title:User1.java </p>
 * <p> Description:测试主键为UUID的用户类 </p>
 * <p> Company: </p>
 *
 * @author ChenFumin
 * @version 1.0
 */
public class User1 {

	// 属性名应该和数据库的字段名对应
	private String id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}

}
