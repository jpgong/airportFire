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
 * �˵��������࣬���ڴ����Զ���˵�
 * @author jpgong
 *
 */
public class MenuManager {
	/**
	 * ����˵��ṹ
	 * @return
	 */
	private static Menu getMenu(){
		
		//��һ��һ���˵�
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("��������");
		
		ViewButton btn11 = new ViewButton();
		btn11.setName("�ٶȵ�ͼ");
		btn11.setType("view");
		btn11.setUrl("http://map.baidu.com/");
		
		ViewButton btn12 = new ViewButton();
		btn12.setName("������Ϣ");
		btn12.setType("view");
		btn12.setUrl("https://baike.baidu.com/item/%E5%A4%A9%E6%B4%A5%E6%BB%A8%E6%B5%B7%E5%9B%BD%E9%99%85%E6%9C%BA%E5%9C%BA");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("����Դ��");
		btn13.setType("view");
		btn13.setUrl("http://www.carnoc.com/");
		
		mainBtn1.setSub_button(new Button[]{btn11,btn12,btn13});
		
		//�ڶ���һ���˵�
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("��������");
		
		ViewButton btn21 = new ViewButton();
		btn21.setName("������������");
		btn21.setType("view");
		btn21.setUrl("http://www.ccaonline.cn/tag/%E6%9C%BA%E5%9C%BA%E6%B6%88%E9%98%B2");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("�ǻ�����");
		btn22.setType("view");
		btn22.setUrl("https://mp.weixin.qq.com/s/-k-9zCPxcWb013vfCoGhjg");
		
		ClickButton btn23 = new ClickButton();
		btn23.setName("ɨ����");
		btn23.setType("scancode_push");
		btn23.setKey("scancode");
		
		mainBtn2.setSub_button(new Button[]{btn21,btn22,btn23});
		
		//������һ���˵�
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("�ҵ�����");
		
		ViewButton btn31 = new ViewButton();
		btn31.setName("�ǻ���������");
		btn31.setType("view");
		btn31.setUrl("http://airportfire.tunnel.qydev.com/AirPort/front/index.html");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("��֤��¼");
		btn32.setType("view");
		//��֤��¼����
//		String oAuthUrl = "http://weixinfire.duapp.com/CaucWeiXin/admin/login.jsp";
		
//		String oAuthUrl = "http://caucweixinfire.tunnel.qydev.com/CaucWeiXin/admin/login.jsp";
		btn32.setUrl("http://caucweixinfire.tunnel.qydev.com/CaucWeiXin/admin/login.jsp");
		
		mainBtn3.setSub_button(new Button[]{btn31,btn32});
		
		Menu menu = new Menu();
		menu.setButton(new Button[]{mainBtn1,mainBtn2,mainBtn3});

		return menu;
	}
	
	public static void main(String[] args) {
		//�������û�Ψһƾ֤
		String appId = "wx6d703c88b5bc1088";
		//�������û�Ψһƾ֤��Կ
		String appSecret = "b31f778501904713db2d9507b58bb742";

		//���ýӿڻ�ȡƾ֤
		TokenBean token = CommonUtil.getToken(appId, appSecret);
		if (token != null) {
			//�����˵�
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			//�жϲ˵��������
			if (result) {
				System.out.println("�����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
			
		}
	}

}
