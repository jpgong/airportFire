package com.weixin.message.req;

import com.weixin.bean.ReqMessageBean;

/**
 * 文本消息
 * @author jpgong
 *
 */
public class TextMessage extends ReqMessageBean{
	//文本消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
