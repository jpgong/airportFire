/**
 * 
 */
package com.weixin.message.resp;

import com.weixin.bean.RespMessageBean;

/**
 * ���û��ظ�һ��������Ϣ���û������������Ϣ���ܹ�ֱ�Ӳ���
 * @author jpgong
 *
 */
public class MusicMessage extends RespMessageBean {
	
	private Music music;
	
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
}
