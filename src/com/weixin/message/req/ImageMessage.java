package com.weixin.message.req;

import com.weixin.bean.ReqMessageBean;

/**
 * ͼƬ��Ϣ
 * @author jpgong
 *
 */
public class ImageMessage extends ReqMessageBean {
	
	//ͼƬ���ӣ���ϵͳ���ɣ�
	private String PicUrl;
	//ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}	
	

}
