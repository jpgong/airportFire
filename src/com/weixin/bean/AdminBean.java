/**
 * 
 */
package com.weixin.bean;

/**
 * ��̨����Ա��¼��Ϣ
 * @author jpgong
 *
 */
public class AdminBean {
	//����Ա��Ϣ���е�Ԫ����Ϣ
	private int id;
	private String userName;
	private String passWord;
	private String salt;
	private String createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
