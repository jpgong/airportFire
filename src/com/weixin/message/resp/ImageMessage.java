/**
 * 
 */
package com.weixin.message.resp;

import com.weixin.bean.RespMessageBean;

/**
 * �ظ�һ��ͼƬ��Ϣ���û�
 * @author jpgong
 *
 */
public class ImageMessage extends RespMessageBean {
	//ͼƬ��Ϣ��
	private Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
}
