/**
 * 
 */
package com.weixin.message.resp;

import com.weixin.bean.RespMessageBean;

/**
 * 向用户回复一条音乐消息，用户点击该音乐消息就能够直接播放
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
