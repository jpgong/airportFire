/**
 * 
 */
package com.weixin.menu;

import com.weixin.Util.CommonUtil;
import com.weixin.Util.MenuUtil;
import com.weixin.bean.TokenBean;
import com.weixin.menu.Button;
import com.weixin.menu.ClickButton;
import com.weixin.menu.ComplexButton;
import com.weixin.menu.Menu;
import com.weixin.menu.ViewButton;

/**
 * 菜单管理器类，用于创建自定义菜单
 * @author jpgong
 *
 */
public class MenuManager {
	/**
	 * 定义菜单结构
	 * @return
	 */
	private static Menu getMenu(){
		
		//第一个一级菜单
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("机场服务");
		
		ViewButton btn11 = new ViewButton();
		btn11.setName("百度地图");
		btn11.setType("view");
		btn11.setUrl("http://map.baidu.com/");
		
		ViewButton btn12 = new ViewButton();
		btn12.setName("机场信息");
		btn12.setType("view");
		btn12.setUrl("https://baike.baidu.com/item/%E5%A4%A9%E6%B4%A5%E6%BB%A8%E6%B5%B7%E5%9B%BD%E9%99%85%E6%9C%BA%E5%9C%BA");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("民航资源网");
		btn13.setType("view");
		btn13.setUrl("http://www.carnoc.com/");
		
		mainBtn1.setSub_button(new Button[]{btn11,btn12,btn13});
		
		//第二个一级菜单
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("机场消防");
		
		ViewButton btn21 = new ViewButton();
		btn21.setName("机场消防事例");
		btn21.setType("view");
		btn21.setUrl("http://www.ccaonline.cn/tag/%E6%9C%BA%E5%9C%BA%E6%B6%88%E9%98%B2");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("智慧消防");
		btn22.setType("view");
		btn22.setUrl("https://mp.weixin.qq.com/s/-k-9zCPxcWb013vfCoGhjg");
		
		ClickButton btn23 = new ClickButton();
		btn23.setName("扫码检查");
		btn23.setType("scancode_push");
		btn23.setKey("scancode");
		
		mainBtn2.setSub_button(new Button[]{btn21,btn22,btn23});
		
		//第三个一级菜单
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("我的消防");
		
		ViewButton btn31 = new ViewButton();
		btn31.setName("智慧消防官网");
		btn31.setType("view");
		btn31.setUrl("http://airportfire.tunnel.qydev.com/AirPort/front/index.html");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("认证登录");
		btn32.setType("view");
		//认证登录链接
//		String oAuthUrl = "http://weixinfire.duapp.com/CaucWeiXin/admin/login.jsp";
		
//		String oAuthUrl = "http://caucweixinfire.tunnel.qydev.com/CaucWeiXin/admin/login.jsp";
		btn32.setUrl("http://caucweixinfire.tunnel.qydev.com/CaucWeiXin/admin/login.jsp");
		
		mainBtn3.setSub_button(new Button[]{btn31,btn32});
		
		Menu menu = new Menu();
		menu.setButton(new Button[]{mainBtn1,mainBtn2,mainBtn3});

		return menu;
	}
	
	public static void main(String[] args) {
		//第三方用户唯一凭证
		String appId = "wx6d703c88b5bc1088";
		//第三方用户唯一凭证密钥
		String appSecret = "b31f778501904713db2d9507b58bb742";

		//调用接口获取凭证
		TokenBean token = CommonUtil.getToken(appId, appSecret);
		if (token != null) {
			//创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			//判断菜单创建结果
			if (result) {
				System.out.println("创建成功");
			}else {
				System.out.println("创建失败");
			}
			
		}
	}

}
