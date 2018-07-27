package com.weixin.menu;

/**
 * 复合类型的按钮，就是含有子菜单的一级菜单
 * @author jpgong
 *
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
