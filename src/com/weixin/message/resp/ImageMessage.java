/**
 * 
 */
package com.weixin.message.resp;

import com.weixin.bean.RespMessageBean;

/**
 * 回复一条图片消息给用户
 * @author jpgong
 *
 */
public class ImageMessage extends RespMessageBean {
	//图片消息类
	private Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}
