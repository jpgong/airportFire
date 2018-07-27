/**
 * 
 */
package com.weixin.event.req;

import com.weixin.bean.ReqEventBean;

/**
 * 自定义菜单事件
 * @author jpgong
 *
 */
public class MenuEvent extends ReqEventBean {
	//事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
