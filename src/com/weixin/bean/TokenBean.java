/**
 * 
 */
package com.weixin.bean;

/**
 * 自定义的凭证类型
 * @author jpgong
 *
 */
public class TokenBean {
	//接口访问凭证
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
