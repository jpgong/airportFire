/**
 * 
 */
package com.weixin.event.req;

import com.weixin.bean.ReqEventBean;

/**
 * 扫描带参数二维码事件
 * @author jpgong
 *
 */
public class QRCodeEvent extends ReqEventBean {
	
	//事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String EventKey;
	//二维码的ticket，可用来换取二维码图片
	private String Ticket;
	
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
