/**
 * 
 */
package com.weixin.bean;

/**
 * �Զ����ƾ֤����
 * @author jpgong
 *
 */
public class TokenBean {
	//�ӿڷ���ƾ֤
	private String accessToken;
	private int expiresIn;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
