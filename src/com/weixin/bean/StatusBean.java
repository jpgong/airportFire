/**
 * 
 */
package com.weixin.bean;

import java.util.Map;

/**
 * 返回的JSon数据格式
 * @author jpgong
 *
 */
public class StatusBean {
	//可能返回的一些状态码
	private int status;
	//返回一些需要封装的数据
	private Map<String, Object> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
