package com.weixin.message.req;

import com.weixin.bean.ReqMessageBean;

/**
 * �ı���Ϣ
 * @author jpgong
 *
 */
public class TextMessage extends ReqMessageBean{
	//�ı���Ϣ����
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
