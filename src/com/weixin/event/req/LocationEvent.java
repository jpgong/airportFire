/**
 * 
 */
package com.weixin.event.req;

import com.weixin.bean.ReqEventBean;

/**
 * �ϱ�����λ���¼�
 * @author jpgong
 *
 */
public class LocationEvent extends ReqEventBean {
	//����λ��γ��
	private String Latitude;
	//����λ�þ���
	private String Longitude;
	//����λ�þ���
	private String Precision;
	
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}

}
