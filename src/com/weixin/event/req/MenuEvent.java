/**
 * 
 */
package com.weixin.event.req;

import com.weixin.bean.ReqEventBean;

/**
 * �Զ���˵��¼�
 * @author jpgong
 *
 */
public class MenuEvent extends ReqEventBean {
	//�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
