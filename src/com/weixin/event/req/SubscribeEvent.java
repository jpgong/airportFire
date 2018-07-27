/**
 * 
 */
package com.weixin.event.req;

import com.weixin.bean.ReqEventBean;

/**
 * 关注事件和取消关注事件的消息类型都是event
 * 参数Event等于subscribe时表示关注事件，
 * 等于unsubscribe表示取消关注事件
 * @author jpgong
 *
 */
public class SubscribeEvent extends ReqEventBean{

}
