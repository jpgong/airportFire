/**
 * 
 */
package com.weixin.bean;

import java.util.Map;

/**
 * ���ص�JSon���ݸ�ʽ
 * @author jpgong
 *
 */
public class StatusBean {
	//���ܷ��ص�һЩ״̬��
	private int status;
	//����һЩ��Ҫ��װ������
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
